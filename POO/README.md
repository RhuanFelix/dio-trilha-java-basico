# Resolução do Desafio de Projeto

Este diretório contém a resolução de um desafio de projeto da DIO, referente à [Trilha Java Básico - POO](https://github.com/digitalinnovationone/trilha-java-basico/tree/main/desafios/poo).

## Diagrama UML das funcionalidades do projeto
```mermaid
classDiagram
    class ReprodutorMusica {
        -historicoMusicas: List<String>
        -in: Scanner
        +tocar()
        +pausar()
        +selecionarMusica(String exemplo)
    }

    class Telefone {
        -historicoTelefonico: List<String>
        -random: Random
        -in: Scanner
        +ligar(String numero)
        +atender()
        +iniciarCorreioVoz()
    }

    class NavegadorWeb {
        -historicoNavegador: List<String>
        -in: Scanner
        -aba: int
        +exibirPagina(String url)
        +adicionarNovaAba()
        +atualizarPagina()
    }

    class iPhone {
        +Lista()
    }

    iPhone --> ReprodutorMusica
    iPhone --> Telefone
    iPhone --> NavegadorWeb
```