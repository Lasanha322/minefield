# Projeto Minefield

# Descrição Resumida do Projeto
Minefield é um jogo competitivo para 2 ou mais jogadores. Dispute com seus amigos para ver quem encontra mais gemas dentro de uma mina representada por um espaço celular. Gaste suas gemas para usar recursos poderosos, como um detector de gemas ou plantando uma bomba que faz quem encontrá-la perder todas as gemas! Nesse jogo altamente customizável, leve e simples, ganha quem souber aproveitar melhor as gemas que encontrar!

# Equipe
* Bruna Rodrigues Barbosa - RA 194966
* Cauan Newton Alves Souza - RA 195620

# Vídeo do Projeto
## Vídeo da Prévia
[![Apresentação do Projeto Minefield](https://cdn.discordapp.com/attachments/694594122585211044/714183631840477264/Untitled.png)](https://drive.google.com/open?id=1QwehsP0wL8AdP_F_CxnumB9chjbt7saR)
## Vídeo do Jogo
> <Coloque um link para o vídeo em que é demonstrada a versão final do jogo. Esse vídeo deve ter em torno de 5 minutos. Este vídeo não apresenta slides, nem substitui a apresentação final do projeto, que será feita por conferência. Ele mostra apenas o jogo em funcionamento.>

# Slides do Projeto
## Slides da Prévia
[Link para os slides](https://docs.google.com/presentation/d/1yb26aykyLqy626uItrTmpXIRKxinTik2M1ZeQIV17pM/edit?usp=sharing)

## Slides da Apresentação Final
[link para os slides](https://docs.google.com/presentation/d/1YpxciGEAO1BESnD6pt4gv8nIQ6txXdxXmmpQrLz0dGE/edit?usp=sharing)

## Relatório de Evolução


# Destaques de Código

~~~java
"public Board(int tamanho, int gemasPraColocar) {
        double gemChance = (double)(gemasPraColocar)/(double)(tamanho);
        Celulas = new ICell[tamanho];

        for(int i = 0; i < tamanho; i++) {
            Celulas[i] = new Cell();

            if (gemasPraColocar > 0) {
                if (tamanho - i <= gemasPraColocar) {
                    Celulas[i].setConteudo(new Gema());
                    gemasPraColocar--;
                } else if (Math.random() < gemChance) {
                    Celulas[i].setConteudo(new Gema());
                    gemasPraColocar--;
                }
            }
        }
    }"
~~~
~~~java
"public void imprimirStart() {
        String IMG_PATH = "assets/img/start/";
        setTitle("Minefield - Main Menu");
        getContentPane().removeAll();
        add(Box.createHorizontalGlue());

        IconButton buttonStart = new IconButton(IMG_PATH + "start");
        buttonStart.setActionCommand("game");
        buttonStart.addActionListener(this);
        IconButton buttonSettings = new IconButton(IMG_PATH + "settings");
        buttonSettings.setActionCommand("settings");
        buttonSettings.addActionListener(this);
        IconButton buttonExit = new IconButton(IMG_PATH + "exit");
        buttonExit.setActionCommand("exit");
        buttonExit.addActionListener(this);

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
        panelButtons.add(buttonStart);
        panelButtons.add(buttonSettings);
        panelButtons.add(buttonExit);

        Background logo = new Background(IMG_PATH + "background", Resolution);
        logo.setSize(new Dimension(Settings.getWindowWidth(), Settings.getWindowHeight()));
        logo.setLayout(new BoxLayout(logo, BoxLayout.Y_AXIS));
        logo.add(Box.createVerticalGlue());
        logo.add(panelButtons);
        panelButtons.setAlignmentX(CENTER_ALIGNMENT);
        logo.add(Box.createRigidArea(new Dimension(0, Settings.getWindowHeight()/10)));

        add(logo);
        add(Box.createHorizontalGlue());
        pack();
        repaint();
    }"
~~~

~~~java
"boolean runGame = true;
        while (runGame) {
            synchronized (Janela) {
                try {
                    Janela.wait(); 
                } catch (InterruptedException e) {
                    runGame = false;
                    System.out.println(e.getMessage());
                    System.out.println("An unexpected error happened and the game will be closed.");
                }
            }

            LastAction = Janela.getLastAction();

            switch(LastAction) {
            case "start":
                Janela.imprimirStart();
                break;
            case "game":
                new Game(Janela);
                break;
            case "settings":
                Janela.imprimirSettings();
                break;
            case "exit":
                Janela.setVisible(false);
                runGame = false;
                break;
            default:
                break;
            }
        }"
~~~

# Destaques de Pattern
`<Destaque de patterns adotados pela equipe. Sugestão de estrutura:>`

## Diagrama do Pattern
`<Diagrama do pattern dentro do contexto da aplicação.>`

## Código do Pattern
~~~java
// Recorte do código do pattern seguindo as mesmas diretrizes de outros destaques
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
}
~~~
> <Explicação de como o pattern foi adotado e quais suas vantagens, referenciando o diagrama.>

# Conclusões e Trabalhos Futuros
> <Apresente aqui as conclusões do projeto e propostas de trabalho futuro. Esta é a oportunidade em que você pode indicar melhorias no projeto a partir de lições aprendidas e conhecimentos adquiridos durante a realização do projeto, mas que não puderam ser implementadas por questões de tempo. Por exemplo, há design patterns aprendidos no final do curso que provavelmente não puderam ser implementados no jogo -- este é o espaço onde você pode apresentar como aplicaria o pattern no futuro para melhorar o jogo.>

# Documentação dos Componentes
# Diagramas
## Diagrama Geral do Projeto
> <Apresente um diagrama geral de organização da organização do seu sistema. O formato é livre. A escolha de um ou mais estilos arquiteturais será considerado um diferencial.>
> <Faça uma breve descrição do diagrama.>

## Diagrama Geral de Componentes
![Diagrama de Componentes do jogo Minefield](images/Minefield-componets.png)

## Componente GUI
> <Resumo do papel do componente e serviços que ele oferece.>

![Componente GUI](images/componentGUI.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Interfaces | IGUI

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](interfacesGUI.png)

Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~

## Detalhamento das Interfaces

### Interface IGUI
Define métodos para a impressão da interface gráfica do jogo.

Método | Objetivo
-------| --------
imprimirStart |
imprimirGame | Imprime o menu inicial do programa, dando caminho pras configurações ou pra iniciar o jogo. Não tem retorno.
imprimeSettings | Imprime o menu para configuração do jogo. Recebe um parâmetro Settings e imprime seus atributos. Não tem retorno.
imprimirWinner| Imprime uma tela mostrando o vencedor da partida. Recebe um parâmetro Player que representa o vencedor e imprime sua pontuação. Não tem retorno.
getLastAction |
getSettings |

## Componente Settings
> <Resumo do papel do componente e serviços que ele oferece.>

![Componente](images/componentSettings.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Interfaces | ISettings

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](images/interfacesSettings.png)

Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~

## Detalhamento das Interfaces

### Interface ISettings
Interface implementada por qualquer objeto que armazene as regras do jogo.

Método | Objetivo
-------| --------
getGanhaQuemTemMais |
getGanhaQuemPegouMais |
getNumeroDeJogadores | 
getTamanhoDoTabuleiro |
getNumeroDeGemas |
getWindowWidth |
getWindowHeight |
setNumeroDeJogadores |
setTamanhoDoTabuleiro |
setNumeroDeGemas |
setGanhaQuemTemMais |
setGanhaQuemPegouMais |
setWindowWidth |
setWindowHeight |

## Componente Game
> <Resumo do papel do componente e serviços que ele oferece.>

![Componente](images/componentGame.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Interfaces | IGame

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](images/interfacesGame.png)
Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~

## Detalhamento das Interfaces

### Interface IGame
Determina os métodos que permitem o controle do estado do jogo.

Método | Objetivo
-------| --------
acabou |
getTurno |
proximoTurno |
getSettings |
getBoard |
getPlayers |
getWinner |

## Componente Player
> <Resumo do papel do componente e serviços que ele oferece.>

![Componente](images/componentPlayer.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Interfaces | IPlayer

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](images/interfacesPlayer.png)
Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~

## Detalhamento das Interfaces

### Interface IPlayer.
Fornece os métodos para controlar a pontuação dos jogadores.

Método | Objetivo
-------| --------
getID |
getGemasAtual | Retorna o total de gemas que um dado jogador pegou ao longo do jogo.
getGemasTotal | Retorna a quantidade atual de gemas de um dado jogador.
setGemasAtual | Altera o total de gemas que um determinado jogador pegou ao longo do jogo. Não tem retorno.
setGemasTotal | Altera a quantidade atual de gemas de um determinado jogador. Não tem retorno.

## Componente Board

> <Resumo do papel do componente e serviços que ele oferece.>

![Componente](images/componentBoard.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Interfaces |IBoard

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](images/interfacesBoard.png)
Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~

## Detalhamento das Interfaces

### Interface IBoard
Interface com os métodos referentes às jogadas possíveis no jogo.

Método | Objetivo
-------| --------
getCell |

## Componente Cell

> <Resumo do papel do componente e serviços que ele oferece.>

![Componente](images/componentGame.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Interfaces | ICell

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](images/interfacesCell.png)
Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~

## Detalhamento das Interfaces

### Interface ICell
Padroniza os métodos para a manipulação das células.

Método | Objetivo
-------| --------
setExaminada |
setRevelada |
setConteudo |
examinada |
revelada |
getConteudo |

## Componente Conteudo

> <Resumo do papel do componente e serviços que ele oferece.>

![Componente](images/componentConteudo.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Interfaces | IConteudo

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](images/interfacesGame.png)
Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~

## Detalhamento das Interfaces

### Interface IConteudo
Define o conteúdo de uma célula.

Método | Objetivo
-------| --------
visivel |

# Plano de Exceções

## Diagrama da hierarquia de exceções
`<Elabore um diagrama com a hierarquia de exceções como detalhado abaixo>`

![Hierarquia Exceções](exception-hierarchy.png)

## Descrição das classes de exceção

`<Monte uma tabela descritiva seguindo o exemplo>:`

Classe | Descrição
----- | -----
DivisaoInvalida | Engloba todas as exceções de divisões não aceitas.
DivisaoInutil | Indica que a divisão por 1 é inútil.
DivisaoNaoInteira | Indica uma divisão não inteira.
