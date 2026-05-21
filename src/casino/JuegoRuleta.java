package casino;

import javax.swing.JOptionPane;

public class JuegoRuleta {
    public static void main(String[] args) {
        
        Juegos partida = new Juegos();
        Ruleta ruleta = partida.getRuleta();
        Cliente jugador = partida.getJugador();

        JOptionPane.showMessageDialog(null, 
            " -- BIENVENIDO A LA RULETA VIRTUAL -- ", 
            "Casino Java", 
            JOptionPane.INFORMATION_MESSAGE);

        // Bucle principal del juego
        
        while (!jugador.estaEnBancarrota()) {
            
            // 1. PANTALLA DE STATUS Y REGLAS
        	
            String mensajeReglas = "ESTADO DE TU CUENTA:\n"
                    + "» Saldo Disponible: $" + jugador.getSaldo() + "\n\n"
                    + "REGLAMENTO DE PAGOS DE LA MESA:\n"
                    + "• Número Directo: Apuestas a un número exacto (0-36). Paga 35 a 1.\n"
                    + "• Color: Apuestas a Rojo o Negro. Paga 1 a 1 (Duplica tu apuesta).\n"
                    + "• El número 0 (Verde) pierde ante cualquier apuesta de color.\n\n"
                    + "Presiona OK para pasar a la mesa de apuestas.";
                    
            JOptionPane.showMessageDialog(null,
            		mensajeReglas,
            		"Status y Reglas",
            		JOptionPane.INFORMATION_MESSAGE);

            // 2. MENÚ PRINCIPAL 
            
            String[] opcionesMenu = {"Número Directo", "Color", "Retirarse"};
            int opcion = JOptionPane.showOptionDialog(
                null,
                "Selecciona el tipo de apuesta que deseas realizar:",
                "Mesa de Apuestas",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesMenu,
                opcionesMenu[0]
            );
            
            	// Si cierra la ventana o presiona "Retirarse"
            
            if (opcion == JOptionPane.CLOSED_OPTION || opcion == 2) {
                JOptionPane.showMessageDialog(null, 
                    "Te retiras con un saldo final de: $" + jugador.getSaldo(), 
                    "Retirada", 
                    JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            // 3. SOLICITAR EL MONTO DE LA APUESTA 
            
            String entradaApuesta = JOptionPane.showInputDialog(null,
            		"¿Cuánto deseas apostar?:",
            		"Monto de Apuesta",
            		JOptionPane.QUESTION_MESSAGE);
            
            if (entradaApuesta == null) continue; 
            
            int montoApuesta;
            try {
                montoApuesta = Integer.parseInt(entradaApuesta);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                		"Debes ingresar un valor numérico válido.", 
                		"Error",
                		JOptionPane.ERROR_MESSAGE);
                continue;
            }

            	// Validar saldo disponible
            
            if (montoApuesta <= 0 || montoApuesta > jugador.getSaldo()) {
                JOptionPane.showMessageDialog(null,
                		"¡Monto inválido o saldo insuficiente!",
                		"Error", 
                		JOptionPane.ERROR_MESSAGE);
                continue; 
            }

            // 4. PROCESAR ACCIONES SEGÚN EL BOTÓN CLIQUEADO
            
            	// Opción 0: Apuesta a Número Directo
            
            if (opcion == 0) {
                String entradaNumero = JOptionPane.showInputDialog(null,
                		"Elige un número entre 0 y 36:",
                		"Apuesta a Número", 
                		JOptionPane.QUESTION_MESSAGE);
                
                if (entradaNumero == null) continue;
                
                int numeroElegido;
                try {
                    numeroElegido = Integer.parseInt(entradaNumero);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                    		"Entrada inválida.",
                    		"Error",
                    		JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                if (numeroElegido < 0 || numeroElegido > 36) {
                    JOptionPane.showMessageDialog(null,
                    		"Número fuera de rango.",
                    		"Error",
                    		JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                	// Cobrar apuesta
                
                jugador.descontarApuesta(montoApuesta);
                
                JOptionPane.showMessageDialog(null, 
                		"Girando la ruleta...",
                		"Ruleta Girando",
                		JOptionPane.WARNING_MESSAGE);
               
                	// Ejecutar funciones de los objetos creados en 'Juegos'
                
                NumeroRuleta resultado = ruleta.girar();
                String mensajeResultado = ">> Cayó el número: " + resultado.getValor() + " (" + resultado.getColor() + ") <<";

                	// Verificar ganancia
                
                if (resultado.getValor() == numeroElegido) {
                    int premio = montoApuesta * 36; 
                    jugador.recibirPremio(premio);
                    
                    JOptionPane.showMessageDialog(null,
                    		mensajeResultado + "\n\n¡Felicidades! Acertaste el número.\nGanaste: $" + (premio - montoApuesta),
                    		"¡Ganaste!",
                    		JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                    		mensajeResultado + "\n\nPerdiste tu apuesta.",
                    		"Resultado",
                    		JOptionPane.ERROR_MESSAGE);
                }

                // Opción 1: Apuesta a Color
                
            } else if (opcion == 1) {
            	
                String[] opcionesColor = {"Rojo", "Negro"};
                int seleccionColor = JOptionPane.showOptionDialog(
                    null,
                    "Elige un color para tu apuesta:",
                    "Apuesta a Color",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesColor,
                    opcionesColor[0]
                );
                
                if (seleccionColor == JOptionPane.CLOSED_OPTION) continue;
                
                String colorElegido = opcionesColor[seleccionColor];

                	// Cobrar apuesta
                
                jugador.descontarApuesta(montoApuesta);

                JOptionPane.showMessageDialog(null,
                		"Girando la ruleta...", 
                		"Ruleta Girando", 
                		JOptionPane.WARNING_MESSAGE);
                
                	// Ejecutar funciones de los objetos creados en 'Juegos'
                
                NumeroRuleta resultado = ruleta.girar();
                String mensajeResultado = ">> Cayó el número: " + resultado.getValor() + " (" + resultado.getColor() + ") <<";

                	// Verificar ganancia de color
                
                if (resultado.getColor().equalsIgnoreCase(colorElegido)) {
                    int premio = montoApuesta * 2; 
                    jugador.recibirPremio(premio);
                    
                    JOptionPane.showMessageDialog(null,
                    		mensajeResultado + "\n\n¡Felicidades! Acertaste el color.\nGanaste: $" + montoApuesta,
                    		"¡Ganaste!",
                    		JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                    		mensajeResultado + "\n\nPerdiste tu apuesta.",
                    		"Resultado",
                    		JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        	// Fin del juego por bancarrota
        
        if (jugador.estaEnBancarrota()) {
            JOptionPane.showMessageDialog(null,
            		"Te has quedado sin dinero. ¡Fin del juego!",
            		"Bancarrota",
            		JOptionPane.ERROR_MESSAGE);
        }
    }
}    