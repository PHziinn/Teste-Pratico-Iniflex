import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

class Pessoa {
    String nome;
    LocalDate dataDeNacimento;
    
    Pessoa(String nome, String dataDeNacimento) {
        this.nome = nome;
        this.dataDeNacimento = LocalDate.parse(dataDeNacimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}

class Funcionario extends Pessoa {
    BigDecimal salario;
    String funcao;
    
    Funcionario(String nome, String dataDeNacimento, BigDecimal salario, String funcao) {
        super(nome, dataDeNacimento);
        this.salario = salario;
        this.funcao = funcao;
    }
    
    void aumentarSalario(BigDecimal percentual) {
        salario = salario.multiply(BigDecimal.ONE.add(percentual.divide(BigDecimal.valueOf(100))));
    }
    
    @Override
    public String toString() {
        return String.format("Nome: %s, Data Nasc: %s, Salário: %,.2f, Função: %s", 
            nome, dataDeNacimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), salario, funcao);
    }
}

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(
            new Funcionario("Maria", "18/10/2000", new BigDecimal("2009.44"), "Operador"),
            new Funcionario("João", "12/05/1990", new BigDecimal("2284.38"), "Operador"),
            new Funcionario("Caio", "02/05/1961", new BigDecimal("9836.14"), "Coordenador"),
            new Funcionario("Miguel", "14/10/1988", new BigDecimal("19119.88"), "Diretor"),
            new Funcionario("Alice", "05/01/1995", new BigDecimal("2234.68"), "Recepcionista"),
            new Funcionario("Heitor", "19/11/1999", new BigDecimal("1582.72"), "Operador"),
            new Funcionario("Arthur", "31/03/1993", new BigDecimal("4071.84"), "Contador"),
            new Funcionario("Laura", "08/07/1994", new BigDecimal("3017.45"), "Gerente"),
            new Funcionario("Heloísa", "24/05/2003", new BigDecimal("1606.85"), "Eletricista"),
            new Funcionario("Helena", "02/09/1996", new BigDecimal("2799.93"), "Gerente")
        ));
        
        funcionarios.removeIf(f -> f.nome.equals("João"));
        funcionarios.forEach(System.out::println);


        System.out.println("\nFuncionários que receberam 10% de aumento.\n");
        funcionarios.forEach(f -> f.aumentarSalario(BigDecimal.TEN));
        
        Map<String, List<Funcionario>> agrupados = funcionarios.stream()
            .collect(Collectors.groupingBy(f -> f.funcao));
        
        agrupados.forEach((funcao, lista) -> {
            System.out.println("\n" + funcao);
            lista.forEach(System.out::println);
        });
        
        System.out.println("\nAniversariantes de Outubro e Dezembro:\n");
        funcionarios.stream()
            .filter(f -> f.dataDeNacimento.getMonthValue() == 10 || f.dataDeNacimento.getMonthValue() == 12)
            .forEach(System.out::println);
        
        Funcionario maisVelho = Collections.min(funcionarios, Comparator.comparing(f -> f.dataDeNacimento));
        System.out.printf("\nFuncionário mais velho: %s, Idade: %d anos\n", maisVelho.nome, LocalDate.now().getYear() - maisVelho.dataDeNacimento.getYear());
        
        System.out.println("\nTodos os funcionários em ordem alfabética:");
        funcionarios.stream().sorted(Comparator.comparing(f -> f.nome)).forEach(System.out::println);
        
        BigDecimal totalSalarios = funcionarios.stream().map(f -> f.salario).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("\nTotal dos salários dos funcionários: %,.2f\n", totalSalarios);
        
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nQuantos Salários mínimo cada funcionario ganha:");

        for (Funcionario f : funcionarios) {
            System.out.printf("%s ganha cerca de %d salários mínimos\n", 
                f.nome, f.salario.divide(salarioMinimo, 0, RoundingMode.DOWN).intValue()
            );
        }

    }
}
