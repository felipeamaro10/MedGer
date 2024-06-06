package Interface;

import Database.Exclude;
import Database.Insert;
import Database.Read;
import Database.Update;

import java.util.Scanner;

public class Menu {
    public static void menu(){
        try(Scanner sc = new Scanner(System.in)){

            while (true){
                System.out.println("");
                System.out.println("1 - Cadastrar");
                System.out.println("2 - Consultar");
                System.out.println("3 - Atualizar");
                System.out.println("4 - Excluir");
                System.out.println("5 - Sair");
                System.out.print("\nEscolha uma opção: ");

                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao){
                    case 1:
                        System.out.println("Digite o número do lote: ");
                        String numero_lote = sc.nextLine();
                        System.out.println("Digite o medicamento: ");
                        String medicamento = sc.nextLine();
                        System.out.println("Digite a quantidade");
                        String quantidade = sc.nextLine();
                        System.out.println("Digite a validade");
                        String validade = sc.nextLine();
                        Insert.insert(numero_lote, medicamento, quantidade, validade);
                        break;
                    case 2:
                        Read.read();
                        break;
                    case 3:
                        System.out.println("Digite o ID de registo do medicamento:");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Qual coluna deseja alterar? ");
                        String coluna = sc.nextLine();
                        System.out.println("Digite o valor a ser atualizado: ");
                        String att = sc.nextLine();
                        Update.update(id, coluna, att);
                        break;
                    case 4:
                        System.out.println("Digite o ID do regitro que deseja excluir: ");
                        int idDelete = sc.nextInt();
                        Exclude.exclude(idDelete);
                        break;
                    case 5:
                        System.out.println("Fechando programa");
                        return;
                    default:
                        System.out.println("\nOpção inválida, tente novamente: ");
                        break;
                }
            }
        }
    }
}
