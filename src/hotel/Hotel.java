/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel;

import hotel.controle.FuncionarioControle;
import hotel.controle.HospedeControle;
import hotel.controle.QuartoReservaControle;
import hotel.controle.ReservaControle;
import hotel.controle.FormaPagamentoControle;
import hotel.controle.ReservaQuartoControle;
import hotel.model.Funcionario;
import hotel.model.Hospede;
import hotel.model.QuartoReserva;
import hotel.model.Reserva;
import hotel.model.FormaPagamento;
import hotel.model.ReservaQuarto;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

public class Hotel {

    private static final HospedeControle hospedeControle = new HospedeControle();
    private static final FuncionarioControle funcionarioControle = new FuncionarioControle();
    private static final FormaPagamentoControle formaPagamentoControle = new FormaPagamentoControle();
    private static final ReservaQuartoControle reservaQuartoControle = new ReservaQuartoControle();
    private static final ReservaControle reservaControle = new ReservaControle();
    private static final QuartoReservaControle quartoDaReservaControle = new QuartoReservaControle();

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Menu:");
            System.out.println("1. Gerenciar Hospedes");
            System.out.println("2. Gerenciar Funcionarios");
            System.out.println("3. Gerenciar Quartos");
            System.out.println("4. Gerenciar Reservas");            
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    gerenciarHospedes(scanner);
                    break;
                case 2:
                    gerenciarFuncionarios(scanner);
                    break;
                case 3:
                    gerenciarQuartosDaReserva(scanner);
                    
                    break;
                case 4:
                    gerenciarReservas(scanner);
                    
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (option != 0);

        scanner.close();
    }

    private static void gerenciarHospedes(Scanner scanner) {
        int option;
        do {
            System.out.println("Gerenciar Hospedes:");
            System.out.println("1. Inserir Hospede");
            System.out.println("2. Atualizar Hospede");
            System.out.println("3. Listar Hospedes");
            System.out.println("4. Apagar Hospede");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    inserirHospede(scanner);
                    break;
                case 2:
                    atualizarHospede(scanner);
                    break;
                case 3:
                    listarHospedes();
                    break;
                case 4:
                    apagarHospede(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (option != 0);
    }

    private static void inserirHospede(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cpf: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento (yyyy-mm-dd): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Hospede hospede = new Hospede();
        hospede.setNome(nome);
        hospede.setCpf(cpf);
        hospede.setDataNascimento(Date.valueOf(dataNascimento));
        hospede.setTelefone(telefone);
        hospede.setEmail(email); 
        hospede.setEndereco(endereco);

        try {
            hospedeControle.inserir(hospede);
            System.out.println("Hospede inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir hospede: " + e.getMessage());
        }
    }

    private static void atualizarHospede(Scanner scanner) {
        System.out.print("ID do Hospede: ");
        int id_hospede = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cpf: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento (yyyy-mm-dd): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Hospede hospede = new Hospede();
        hospede.setId_hospede(id_hospede);
        hospede.setNome(nome);
        hospede.setEmail(email);
        hospede.setTelefone(telefone);
        hospede.setCpf(cpf);
        hospede.setDataNascimento(Date.valueOf(dataNascimento));
        hospede.setEndereco(endereco);

        try {
            hospedeControle.atualizar(hospede);
            System.out.println("Hospede atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar hospede: " + e.getMessage());
        }
    }

    private static void listarHospedes() {
        try {
            List<Hospede> hospedes = hospedeControle.listar();
            for (Hospede hospede : hospedes) {
                System.out.println("\nid hospede:"+ hospede.getId_hospede()+" | Nome:"+ hospede.getNome() +" | CPF:"+ hospede.getCpf()+" | Data Nascimento:" + hospede.getDataNascimento() +" | Telefone:" + hospede.getTelefone() + " | Email:" + hospede.getEmail()   +  " | Endereco:" + hospede.getEndereco());
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Erro ao listar hospedes: " + e.getMessage());
        }
    }

    private static void apagarHospede(Scanner scanner) {
        System.out.print("ID do Hospede: ");
        int id_hospede = scanner.nextInt();

        try {
            hospedeControle.apagar(id_hospede);
            System.out.println("Hospede apagado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao apagar hospede: " + e.getMessage());
        }
    }

    private static void gerenciarFuncionarios(Scanner scanner) {
        int option;
        do {
            System.out.println("Gerenciar Funcionarios:");
            System.out.println("1. Inserir Funcionario");
            System.out.println("2. Atualizar Funcionario");
            System.out.println("3. Listar Funcionarios");
            System.out.println("4. Apagar Funcionario");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    inserirFuncionario(scanner);
                    break;
                case 2:
                    atualizarFuncionario(scanner);
                    break;
                case 3:
                    listarFuncionarios();
                    break;
                case 4:
                    apagarFuncionario(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("opcao invalida!");
                    break;
            }
        } while (option != 0);
    }

    private static void inserirFuncionario(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Nascimento (yyyy-mm-dd): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Salario: ");
        BigDecimal salario = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.print("Turno: ");
        String turno = scanner.nextLine();
        
        
        
        
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setDataNascimento(Date.valueOf(dataNascimento));
        funcionario.setCargo(cargo);   
        funcionario.setSalario(salario);
        funcionario.setTurno(turno);

        try {
            funcionarioControle.inserir(funcionario);
            System.out.println("Funcionario inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir funcionario: " + e.getMessage());
        }
    }

    private static void atualizarFuncionario(Scanner scanner) {
        System.out.print("ID do Funcionario: ");
        int id_funcionario = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Nascimento (yyyy-mm-dd): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Salario: ");
        BigDecimal salario = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.print("Turno: ");
        String turno = scanner.nextLine();       
        

        Funcionario funcionario = new Funcionario();
        funcionario.setId_fucionario(id_funcionario);
        funcionario.setNome(nome);
        funcionario.setDataNascimento(Date.valueOf(dataNascimento));
        funcionario.setCargo(cargo);
        funcionario.setTurno(turno);
        funcionario.setSalario(salario);
        
        
        try {
            funcionarioControle.atualizar(funcionario);
            System.out.println("Funcionario atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionario: " + e.getMessage());
        }
    }

    private static void listarFuncionarios() {
        try {
            List<Funcionario> funcionarios = funcionarioControle.listar();
            for(Funcionario funcionario:funcionarios){
            System.out.println("\nid funcionario: " + funcionario.getId_fucionario()+ " | Nome: " + funcionario.getNome() + " | Data de Nascimento " + funcionario.getDataNascimento()+ " | Turno: " + funcionario.getTurno()+ " | Cargo: " + funcionario.getCargo() + " | Salario: "+funcionario.getSalario()); 
            
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Erro ao listar funcionarios: " + e.getMessage());
        }
    }

    private static void apagarFuncionario(Scanner scanner) {
        System.out.print("ID do Funcionario: ");
        int id_funcionario = scanner.nextInt();
        scanner.nextLine();

        try {
            funcionarioControle.apagar(id_funcionario);
            System.out.println("Funcionario excluido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir funcionário: " + e.getMessage());
        }
    }

    /*private static void gerenciarTiposDeQuarto(Scanner scanner) {
        int option;
        do {
            System.out.println("Gerenciar Tipos de Quarto:");
            System.out.println("1. Inserir Tipo de Quarto");
            System.out.println("2. Atualizar Tipo de Quarto");
            System.out.println("3. Listar Tipos de Quarto");
            System.out.println("4. Apagar Tipos de Quarto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    inserirTipoDeQuarto(scanner);
                    break;
                case 2:
                    atualizarTipoDeQuarto(scanner);
                    break;
                case 3:
                    listarTiposDeQuarto();
                    break;
                case 4:
                    apagarTipoDeQuarto(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (option != 0);
    }

    private static void inserirTipoDeQuarto(Scanner scanner) {
        System.out.print("Descricao: ");
        String descricao = scanner.nextLine();
        System.out.print("Preco da Diaria: ");
        BigDecimal precoDiaria = scanner.nextBigDecimal();
        scanner.nextLine();

        TipoQuarto tipoDeQuarto = new TipoQuarto();
        tipoDeQuarto.setDescricao(descricao);
        tipoDeQuarto.setPrecoDiaria(precoDiaria);

        try {
            tipoDeQuartoControle.inserir(tipoDeQuarto);
            System.out.println("Tipo de Quarto inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Tipo de Quarto: " + e.getMessage());
        }
    }

    private static void atualizarTipoDeQuarto(Scanner scanner) {
        System.out.print("ID do Tipo de Quarto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Preço da Diária: ");
        BigDecimal precoDiaria = scanner.nextBigDecimal();
        scanner.nextLine();

        TipoQuarto tipoDeQuarto = new TipoQuarto();
        tipoDeQuarto.setId(id);
        tipoDeQuarto.setDescricao(descricao);
        tipoDeQuarto.setPrecoDiaria(precoDiaria);

        try {
            tipoDeQuartoControle.atualizar(tipoDeQuarto);
            System.out.println("Tipo de Quarto atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Tipo de Quarto: " + e.getMessage());
        }
    }

    private static void listarTiposDeQuarto() {
        try {
            List<TipoQuarto> tiposDeQuarto = tipoDeQuartoControle.listar();
            for (TipoQuarto tipoDeQuarto : tiposDeQuarto) {
                System.out.println("\nid Tipo De Quarto: " + tipoDeQuarto.getId() + " | descriçao: " + tipoDeQuarto.getDescricao() + " | preço diaria: " + tipoDeQuarto.getPrecoDiaria());
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Erro ao listar Tipos de Quarto: " + e.getMessage());
        }
    }

    private static void apagarTipoDeQuarto(Scanner scanner) {
        System.out.print("ID do Tipo de Quarto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            tipoDeQuartoControle.apagar(id);
            System.out.println("Tipo de Quarto excluido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir Tipo de Quarto: " + e.getMessage());
        }
               
    }
*/
    private static void gerenciarReservas(Scanner scanner) throws SQLException {
        int option;
        do {
            System.out.println("Gerenciar Reservas:");
            System.out.println("1. Inserir Reserva");
            System.out.println("2. Atualizar Reserva");
            System.out.println("3. Listar Reservas");
            System.out.println("4. Apagar Reserva");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    inserirReserva(scanner);
                    break;
                case 2:
                    atualizarReserva(scanner);
                    break;
                case 3:
                    listarReservas();
                    //listarReservas2();
                   //listarReservas3();
                    break;
                case 4:
                    apagarReserva(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao inválida!");
                    break;
            }
        } while (option != 0);
    }

    private static void inserirReserva(Scanner scanner) throws SQLException {

        int quantidade = reservaControle.verificaQuantidadeReservas();

        if (quantidade >= 100) {
            System.out.println("\nO numero disponivel de reservas hoje foi atingido\n");
            return;
        }
        
        //System.out.print("Qual vai ser o metodo de pagamento: ");
        //String metodoPagamento = scanner.nextLine();
        
        //System.out.print("ID do Quarto: ");
        //int id_quarto = scanner.nextInt();
 
        System.out.print("ID do Hóspede: ");
        int id_hospede = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Numero Reserva ");
        int numeroReserva = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Data de Check-in (yyyy-mm-dd): ");
        String dataCheckin = scanner.nextLine();
        System.out.print("Data de Check-out (yyyy-mm-dd): ");
        String dataCheckout = scanner.nextLine();

        System.out.print("Data de Reserva (yyyy-mm-dd): ");
        String dataReserva = scanner.nextLine();
        System.out.print("Numero de Hospedes: ");
        int numeroHospedes = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Status Pagamento: ");
        String statusPagamento = scanner.nextLine();
        System.out.print(" Valor total: ");
        BigDecimal valor = scanner.nextBigDecimal();
        System.out.print("ID do Pagamento: ");
        int id_pagamento = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID do Funcionario: ");
        int id_funcionario = scanner.nextInt();
        scanner.nextLine();
     
        Reserva reserva = new Reserva();
        //FormaPagamento formaPagamento = new FormaPagamento();
        //ReservaQuarto reservaQuarto = new ReservaQuarto();
        //formaPagamento.setMetodoPagamento(metodoPagamento);
        //reservaQuarto.setId_Quarto(id_quarto);
        reserva.setId_hospede(id_hospede);
        reserva.setNumeroReserva(numeroReserva);
        reserva.setDataCheckin(Date.valueOf(dataCheckin));
        reserva.setDataCheckout(Date.valueOf(dataCheckout));
        reserva.setDataReserva(Date.valueOf(dataReserva));
        reserva.setNumeroHospedes(numeroHospedes);
        reserva.setStatusPagamento(statusPagamento);
        reserva.setValor(valor);
        reserva.setId_pagamento(id_pagamento);
        reserva.setId_funcionario(id_funcionario);
        
      
        

        try {
           // reservaQuartoControle.inserir(reservaQuarto);
            //formaPagamentoControle.inserir(formaPagamento);
            reservaControle.inserir(reserva);
            System.out.println("Reserva inserida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir reserva: " + e.getMessage());
        }
    }

    private static void atualizarReserva(Scanner scanner) {
        System.out.print("ID da Reserva: ");
        int id_reserva = scanner.nextInt();
        scanner.nextLine();
        
       // System.out.print("ID do Quarto: ");
        //int id_quarto = scanner.nextInt();

        System.out.print("ID do Hospede: ");
        int id_hospede = scanner.nextInt();
        scanner.nextLine();
        
        
        //System.out.print("Atualizar o metodo de pagamento: ");
        //String metodoPagamento = scanner.nextLine();
        
        System.out.print("Numero Reserva ");
        int numeroReserva = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Data de Check-in (yyyy-mm-dd): ");
        String dataCheckin = scanner.nextLine();
        System.out.print("Data de Check-out (yyyy-mm-dd): ");
        String dataCheckout = scanner.nextLine();
       
        System.out.print("Data de Reserva (yyyy-mm-dd): ");
        String dataReserva = scanner.nextLine();
        System.out.print("Numero de Hospedes: ");
        int numeroHospedes = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Status Pagamento: ");
        String statusPagamento = scanner.nextLine();
        System.out.print(" Valor total: ");
        BigDecimal valor = scanner.nextBigDecimal();
        
        System.out.print("ID do Pagamento: ");
        int id_pagamento = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("ID do Funcionario: ");
        int id_funcionario = scanner.nextInt();
        scanner.nextLine();

        Reserva reserva = new Reserva();
        //FormaPagamento formaPagamento = new FormaPagamento();
        //ReservaQuarto reservaQuarto = new ReservaQuarto();
       // formaPagamento.setMetodoPagamento(metodoPagamento);
        //reservaQuarto.setId_Quarto(id_quarto);
        reserva.setId_reserva(id_reserva);
        reserva.setId_hospede(id_hospede);
        reserva.setNumeroReserva(numeroReserva);
        reserva.setDataCheckin(Date.valueOf(dataCheckin));
        reserva.setDataCheckout(Date.valueOf(dataCheckout));
        reserva.setDataReserva(Date.valueOf(dataReserva));
        reserva.setNumeroHospedes(numeroHospedes);
        reserva.setStatusPagamento(statusPagamento);
        reserva.setValor(valor);
        reserva.setId_pagamento(id_pagamento);
        reserva.setId_funcionario(id_funcionario);

        try {
            //reservaQuartoControle.atualizar(reservaQuarto);
            //formaPagamentoControle.atualizar(formaPagamento);
            reservaControle.atualizar(reserva);
            System.out.println("Reserva atualizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar reserva: " + e.getMessage());
        }
    }

    private static void listarReservas() {
        try {
            List<Reserva> reservas = reservaControle.listar();
            for (Reserva reserva : reservas) {
                System.out.println("\n Id Reserva: " + reserva.getId_reserva()
                        +"| Id do Hospede: " + reserva.getId_hospede() 
                        +"| id Funcionario: "+reserva.getId_funcionario()
                        +"| id Pagamento: "+reserva.getId_pagamento()
                        +"| Numero Reserva: "+ reserva.getNumeroReserva()
                        +"| Data checkin: " + reserva.getDataCheckin() 
                        +"| Data checkout: " + reserva.getDataCheckout()
                        +"| Data da reserva: " + reserva.getDataReserva()
                        +"| Numero Hospedes: "+reserva.getNumeroHospedes()
                        +"| Status Pagamento: "+reserva.getStatusPagamento()
                        +"| Valor Total: "+reserva.getValor());
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Erro ao listar reservas: " + e.getMessage());
        }
    }
     private static void listarReservas2() {
        try {
            List<ReservaQuarto>ReservaaQuarto = reservaQuartoControle.listar();
            for (ReservaQuarto reservaquarto : ReservaaQuarto) {
                System.out.println("| Id Quarto: " + reservaquarto.getId_Quarto());
            
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Erro ao listar : " + e.getMessage());
        }
    }
       private static void listarReservas3() {
        try {
            List<FormaPagamento>formaPagamentos = formaPagamentoControle.listar();
            for (FormaPagamento formapagamento : formaPagamentos) {
                System.out.println("| Forma pagamento: " + formapagamento.getMetodoPagamento());
                        
                        
          }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Erro ao listar : " + e.getMessage());
        }
    }

    private static void apagarReserva(Scanner scanner) {
        System.out.print("ID da Reserva: ");
        int id_reserva = scanner.nextInt();
        scanner.nextLine();

        try {
            //formaPagamentoControle.apagar(id_reserva);
            //eservaQuartoControle.apagar(id_reserva);
            reservaControle.apagar(id_reserva);
            System.out.println("Reserva excluida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir reserva: " + e.getMessage());
        }
    }

    private static void gerenciarQuartosDaReserva(Scanner scanner) {
        int option;
        do {
            System.out.println("Gerenciar Quartos da Reserva:");
            System.out.println("1. Inserir Quarto ");
            System.out.println("2. Atualizar Quarto ");
            System.out.println("3. Listar Quartos ");
            System.out.println("4. Apagar Quartos ");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    inserirQuartoDaReserva(scanner);
                    break;
                case 2:
                    atualizarQuartoDaReserva(scanner);
                    break;
                case 3:
                    listarQuartosDaReserva();
                    break;
                case 4:
                    apagarQuartoDaReserva(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("opcao inválida!");
                    break;
            }
        } while (option != 0);
    }

    private static void inserirQuartoDaReserva(Scanner scanner) {
        
        System.out.print("Numero do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo de Quarto: ");
        String tipo = scanner.nextLine();
        System.out.print("Andar do Quarto: ");
        int andarQuarto = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ocupação maxima: ");
        int ocupacaoMaxima = scanner.nextInt();
        scanner.nextLine();
          
        QuartoReserva quartoDaReserva = new QuartoReserva();      
        quartoDaReserva.setNumeroQuarto(numeroQuarto);
        quartoDaReserva.setTipo(tipo);
        quartoDaReserva.setAndarQuarto(andarQuarto);
        quartoDaReserva.setOcupacaoMaxima(ocupacaoMaxima);

        try {
            quartoDaReservaControle.inserir(quartoDaReserva);
            System.out.println("Quarto  inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Quarto : " + e.getMessage());
        }
    }

    private static void atualizarQuartoDaReserva(Scanner scanner) {
        System.out.print("ID do Quarto: ");
        int id_quarto = scanner.nextInt();
        scanner.nextLine();

       
        System.out.print("numero do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine();
        System.out.print("tipo: ");
        String tipo = scanner.nextLine();
        
        System.out.print("Andar do quarto: ");
        int andarQuarto = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ocupação maxima: ");
        int ocupacaoMaxima = scanner.nextInt();
        scanner.nextLine();
        
        QuartoReserva quartoDaReserva = new QuartoReserva();
        quartoDaReserva.setId_quarto(id_quarto);        
        quartoDaReserva.setNumeroQuarto(numeroQuarto);
        quartoDaReserva.setTipo(tipo);
        quartoDaReserva.setAndarQuarto(andarQuarto);
        
        quartoDaReserva.setOcupacaoMaxima(ocupacaoMaxima);

        try {
            quartoDaReservaControle.atualizar(quartoDaReserva);
            System.out.println("Quarto  atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Quarto : " + e.getMessage());
        }
    }

    private static void listarQuartosDaReserva() {
        try {
             
            List<QuartoReserva> quartosDaReserva = quartoDaReservaControle.listar();
            for (QuartoReserva quartoDaReserva : quartosDaReserva) {
                System.out.println("\n Id do quarto: " + quartoDaReserva.getId_quarto()+
                                   " | Numero Quarto: " + quartoDaReserva.getNumeroQuarto()+
                                   " | Tipo do Quarto: " + quartoDaReserva.getTipo()+
                                   " | Andar Quarto: " + quartoDaReserva.getAndarQuarto()+ 
                                   " | Ocupação maxima: " + quartoDaReserva.getOcupacaoMaxima());
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Erro ao listar Quartos : " + e.getMessage());
        }
    }

    private static void apagarQuartoDaReserva(Scanner scanner) {
        System.out.print("ID do Quarto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            quartoDaReservaControle.apagar(id);
            System.out.println("Quarto  excluido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir Quarto : " + e.getMessage());
        }
    }
}
