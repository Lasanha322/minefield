# Projeto Minefield

# Equipe
* Bruna Rodrigues Barbosa - RA 194966
* Cauan Newton Alves Souza - RA 195620

# Descrição Resumida do Projeto
Minefield é um jogo competitivo para 1 ou mais jogadores. Dispute com seus amigos para ver quem encontra mais gemas dentro de uma mina representada por um espaço celular. Gaste suas gemas para usar recursos poderosos, como um detector de gemas ou plantando uma bomba que faz quem encontrá-la perder todas as gemas! Nesse jogo altamente customizável, leve e simples, ganha quem souber aproveitar melhor as gemas que encontrar!

# Slides de Apresentação
[Link para os slides](https://docs.google.com/presentation/d/1yb26aykyLqy626uItrTmpXIRKxinTik2M1ZeQIV17pM/edit?usp=sharing)

# Vídeo do Projeto
[![Apresentação do Projeto Minefield](https://cdn.discordapp.com/attachments/694594122585211044/714183631840477264/Untitled.png)](https://drive.google.com/open?id=1QwehsP0wL8AdP_F_CxnumB9chjbt7saR)

# Diagrama Geral de Componentes
![Diagrama de Componentes do jogo Minefield](images/minefield_diagram.png)

# Componente GUI

![Componente GUI](images/componentGUI.png)

## Interfaces

Interfaces associadas a esse componente:

![Interfaces do componente GUI](images/interfacesGUI.png)

Campo | Valor
----- | -----
Classe | src.componentGUI
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Objetivo | Permitir a impressão da interface gráfica do jogo
Interface | IGUI

## Detalhamento das Interfaces

### Interface IGUI
Define métodos para a impressão da interface gráfica do jogo.

Método | Objetivo
-------| --------
imprimeMainMenu | Imprime o menu inicial do programa, dando caminho pras configurações ou pra iniciar o jogo. Não tem retorno.
imprimeSettings | Imprime o menu para configuração do jogo. Recebe um parâmetro Settings e imprime seus atributos. Não tem retorno.
imprimeGame | Imprime o estado atual do jogo, dando as opções que o jogador desse turno pode fazer. Recebe um parâmetro Game com todos os dados do jogo. Não tem retorno.
imprimeVencedor | Imprime uma tela mostrando o vencedor da partida. Recebe um parâmetro Player que representa o vencedor e imprime sua pontuação. Não tem retorno.

# Componente Settings

![Componente](images/componentSettings.png)

## Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](images/interfacesSettings.png)

Campo | Valor
----- | -----
Classe | src.componentSettings
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Objetivo | Armazenar as regras do jogo
Interface | ISettings

## Detalhamento das Interfaces

### Interface ISettings
Interface implementada por qualquer objeto que armazene as regras do jogo.

Método | Objetivo
-------| --------
getNumeroDeJogadores | 
getTamanhoDoTabuleiro |
getNumeroDeGemas |
getGanhaQuemTemMais |
getGanhaQuemPegouMais |
setNumeroDeJogadores |
setTamanhoDoTabuleiro |
setNumeroDeGemas |
setGanhaQuemTemMais |
setGanhaQuemPegouMais |

# Componente Game

![Componente](images/componentGame.png)

## Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](images/interfacesGame.png)

Campo | Valor
----- | -----
Classe | src.componentGame
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Objetivo | Fazer o controle dos elementos do jogo (tabuleiro e pontuação) com base nas configurações
Interface | IGame

## Detalhamento das Interfaces

### Interface IGame
Determina os métodos que permitem o controle do estado do jogo.

Método | Objetivo
-------| --------
esperarJogada |
verificarJogada |
verificarFinal |

# Componente Player

![Componente](images/componentScore.png)

## Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](images/interfacesScore.png)

Campo | Valor
----- | -----
Classe | src.componentPlayer
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Objetivo | Controlar a pontuação de cada jogador
Interface | IScore

## Detalhamento das Interfaces

### Interface IScore.
Fornece os métodos para controlar a pontuação dos jogadores.

Método | Objetivo
-------| --------
getGemasAtual | Retorna o total de gemas que um dado jogador pegou ao longo do jogo.
getGemasTotal | Retorna a quantidade atual de gemas de um dado jogador.
setGemasAtual | Altera o total de gemas que um determinado jogador pegou ao longo do jogo. Não tem retorno.
setGemasTotal | Altera a quantidade atual de gemas de um determinado jogador. Não tem retorno.

# Componente Board

![Componente](images/componentBoard.png)

## Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](images/interfacesBoard.png)

Campo | Valor
----- | -----
Classe | src.componentBoard
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Objetivo | Controlar o estado das células do tabuleiro
Interface | IBoard

## Detalhamento das Interfaces

### Interface IBoard
Interface com os métodos referentes às jogadas possíveis no jogo.

Método | Objetivo
-------| --------
revelarCelula | Revela o conteúdo de uma dada célula do tabuleiro. Retorna o conteúdo dessa célula.
revelar4Celulas | Revela, sequencialmente, o conteúdo de 4 células diferentes do tabuleiro. Não tem retorno.
visualizarCelula | Visualiza o conteúdo de uma dada célula, sem revelá-la. Retorna o conteúdo da célula.
colocarBomba | Esconde uma bomba numa determinada célula. Não tem retorno.
colocarBombaInvisivel | Esconde uma bomba numa determinada célula. Essa bomba não é detectável pelo método visualizarCelula. Não tem retorno.
descobrirGema | Revela aleatoriamente uma célula que esconde uma gema. Retorna uma célula escolhida aleatoriamente que contém uma gema.

# Componente Cell

![Componente](images/componentCell.png)

## Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](images/interfacesCell.png)

Campo | Valor
----- | -----
Classe | src.componentCell
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Objetivo | Fornecer os métodos que podem ser realizados sobre as células
Interface | ICell

## Detalhamento das Interfaces

### Interface ICell
Padroniza os métodos para a manipulação das células.

Método | Objetivo
-------| --------
getConteudo |
getRevelada |
setConteudo |
setRevelada |

# Componente Conteudo

![Componente](images/componentConteudo.png)

## Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](images/interfacesConteudo.png)

Campo | Valor
----- | -----
Classe | src.componentGema
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Objetivo | Objeto de pontuação do jogo
Interface | IConteudo

Campo | Valor
----- | -----
Classe | src.componentBomba
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Objetivo | Objeto que faz o jogador perder todas as gemas, mas que pode ser visualizada
Interface | IConteudo

Campo | Valor
----- | -----
Classe | src.componentBombaInvisivel
Autores | Bruna Rodrigues Barbosa <br> Cauan Newton Alves Souza
Objetivo | Objeto invisível que faz o jogador perder todas as gemas
Interface | IConteudo
## Detalhamento das Interfaces

### Interface IConteudo
Define o conteúdo de uma célula.

Método | Objetivo
-------| --------
getVisibilidade |
