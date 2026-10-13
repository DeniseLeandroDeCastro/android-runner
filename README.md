
<div align="center">

<img width="1600" height="550" alt="Banner oficial do AndroidRunner" src="https://github.com/user-attachments/assets/64564d93-6591-4fd9-be99-8a30cad68585" />

# AndroidRunner

### Corra • Salte • Colete • Supere seu recorde

**Um Endless Runner desenvolvido nativamente para Android com Kotlin e Jetpack Compose.**

![Android](https://img.shields.io/badge/Android-Nativo-3DDC84?style=flat-square&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-2.2.10-7F52FF?style=flat-square&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack-Compose-4285F4?style=flat-square)
![MVVM](https://img.shields.io/badge/Arquitetura-MVVM-2454C6?style=flat-square)
![Testes](https://img.shields.io/badge/Testes-20%20aprovados-238636?style=flat-square)

**MVVM • StateFlow • Clean Architecture • Hilt • Room • DataStore**

Um projeto autoral que combina desenvolvimento Android, física de jogos, arquitetura de software e testes automatizados.

</div>

---

## Sumário

1. [Sobre o AndroidRunner](#sobre-o-androidrunner)
2. [O jogo em imagens](#o-jogo-em-imagens)
3. [Como jogar](#como-jogar)
4. [Funcionalidades](#funcionalidades)
5. [Sistema de pontuação](#sistema-de-pontuação)
6. [Documentação técnica](#documentação-técnica)
7. [Tecnologias utilizadas](#tecnologias-utilizadas)
8. [Testes automatizados](#testes-automatizados)
9. [Como executar](#como-executar)
10. [Evolução do projeto](#evolução-do-projeto)
11. [Autora](#autora)

---

# Sobre o AndroidRunner

O **AndroidRunner** é um jogo Android no estilo **Endless Runner**, desenvolvido do zero utilizando Kotlin e Jetpack Compose. Em um Endless Runner, o personagem permanece em movimento enquanto o jogador precisa superar os desafios que aparecem pelo caminho. No AndroidRunner, o protagonista é um personagem inspirado no universo Android, com roupa esportiva azul, que percorre um cenário colorido, salta sobre obstáculos e coleta itens especiais. O objetivo é simples: **Sobreviver pelo maior tempo possível, acumular pontos e superar o próprio recorde.** Além da experiência de jogo, o projeto foi criado para aplicar conceitos utilizados no desenvolvimento profissional de aplicativos Android. Entre eles:

- Arquitetura MVVM.
- Princípios de Clean Architecture.
- Separação de responsabilidades.
- Componentização.
- Gerenciamento de estado.
- Injeção de dependências.
- Persistência local.
- Física aplicada a jogos.
- Detecção de colisões.
- Testes automatizados.

Uma das principais decisões técnicas foi manter **a física e as regras do jogo independentes da interface desenvolvida com Jetpack Compose**.

---

# O jogo em imagens

<div align="center">

### Tela inicial e Gameplay

<img src="https://github.com/user-attachments/assets/7e703a56-a3a0-4adb-bb81-81a5d19e91a3" width="290" alt="Tela inicial do AndroidRunner" />
&nbsp;
<img src="https://github.com/user-attachments/assets/3e881eb8-77a1-4d23-acea-e7c19ba17b9e" width="290" alt="Gameplay do AndroidRunner" /> <br><br>
O AndroidRunner possui uma identidade visual própria, com personagem, cenário, obstáculos e coletáveis. As telas incluem:

</div>

- Home.
- Gameplay.
- Ranking.
- Como Jogar.
- Opções.

---

# Como jogar

O AndroidRunner possui uma mecânica simples de aprender.

1. Toque em **Jogar** para iniciar uma partida.
2. Toque na tela para fazer o personagem saltar.
3. Desvie dos obstáculos.
4. Colete itens especiais para ganhar pontos extras.
5. Sobreviva pelo maior tempo possível.
6. Supere seu recorde e conquiste uma posição no ranking.

Durante a corrida, o nível de dificuldade aumenta progressivamente. Quando o personagem colide com um obstáculo, a partida termina. O jogador pode iniciar uma nova tentativa ou retornar à tela inicial.

---

# Funcionalidades

| Funcionalidade | Descrição |
|---|---|
| Corrida contínua | Obstáculos se movimentam pelo cenário |
| Salto e gravidade | Física aplicada ao movimento vertical |
| Obstáculos variados | Diferentes elementos aparecem durante a partida |
| Coletáveis | Itens especiais oferecem pontos extras |
| Pontuação dinâmica | Pontos por tempo e por itens coletados |
| Dificuldade progressiva | Aumenta o desafio durante a corrida |
| Detecção de colisões | Identifica contatos com obstáculos e coletáveis |
| Pausar e continuar | Permite interromper e retomar a partida |
| Game Over | Encerra a partida após uma colisão |
| Reiniciar | Inicia uma nova tentativa |
| Recorde | Armazena a maior pontuação |
| Ranking | Apresenta as melhores pontuações |
| Como Jogar | Explica as regras |
| Opções | Permite controlar som e vibração |

---

# Sistema de pontuação

O AndroidRunner combina duas formas de pontuação.

### Pontuação por tempo

O jogador acumula pontos enquanto permanece na corrida.

### Pontuação por coletáveis

Itens especiais aparecem durante a partida e oferecem pontos adicionais.

| Coletável | Pontuação |
|---|---:|
| Android Coin | 100 |
| Code Token | 150 |
| Energy Bolt | 150 |
| Data Chip | 200 |
| Battery | 200 |
| Bug Fix | 250 |
| Kotlin Gem | 300 |
| Star XP | 500 |

Cada coletável possui um peso de aparecimento.

Esse peso influencia a frequência com que determinado item pode surgir durante a corrida.

---

# Documentação técnica

Esta seção apresenta a organização interna do AndroidRunner e explica os conceitos utilizados no desenvolvimento. O objetivo é permitir que desenvolvedores iniciantes e experientes compreendam **como o projeto funciona, quais são as responsabilidades de cada parte e como os componentes se comunicam**.

---

## 1. Visão geral da arquitetura

O AndroidRunner utiliza **MVVM (Model-View-ViewModel)**, fluxo unidirecional de dados e princípios de Clean Architecture. A ideia principal é separar as responsabilidades. A interface não precisa calcular a física do personagem. O Game Engine não precisa conhecer os componentes visuais. O ViewModel não precisa implementar diretamente o armazenamento dos dados. Cada parte possui uma função específica.

### Organização das responsabilidades

| Parte | Responsabilidade |
|---|---|
| Screen | Apresentar a interface |
| Component | Representar um elemento visual reutilizável |
| Route | Conectar a tela ao ViewModel e à navegação |
| ViewModel | Coordenar eventos e estado |
| Game Engine | Executar regras de física e colisões |
| Repository | Organizar o acesso aos dados |
| Room | Persistir dados estruturados |
| DataStore | Persistir preferências e informações simples |

### Fluxo geral

```text
                 JOGADOR
                    |
                    v
               GAME SCREEN
                    |
                    v
                UI EVENT
                    |
                    v
               GAME ROUTE
                    |
                    v
              GAME VIEWMODEL
                    |
          +---------+---------+
          |                   |
          v                   v
      GAME ENGINE         REPOSITORIES
          |                   |
          v                   v
  Física e colisões     Room / DataStore
          |
          v
       GAME UI STATE
          |
          v
        STATEFLOW
          |
          v
       GAME SCREEN
```

Esse fluxo representa as principais responsabilidades. Nem toda interação precisa percorrer todas as partes.

---

## 2. O que é MVVM?

MVVM significa **Model-View-ViewModel**. É um padrão arquitetural utilizado para organizar aplicações, separando a apresentação visual do comportamento e dos dados.

### View

A View representa a interface. No AndroidRunner, ela é construída com Jetpack Compose.

Exemplos:

- `HomeScreen`
- `GameScreen`
- `RankingScreen`
- `HowToPlayScreen`
- `SettingsScreen`

A responsabilidade dessas telas é apresentar informações e receber interações. Por exemplo, a `GameScreen` apresenta:

- Personagem.
- Cenário.
- Obstáculos.
- Coletáveis.
- Pontuação.
- Botão de pausa.

Ela não precisa implementar os cálculos de gravidade ou colisão.

### ViewModel

O ViewModel coordena o comportamento da tela. No Gameplay, o `GameViewModel` recebe eventos e gerencia informações como:

- Estado da partida.
- Posição do personagem.
- Pontuação.
- Obstáculos.
- Coletáveis.
- Pausa.
- Game Over.
- Recorde.

O ViewModel também coordena a execução das regras do Game Engine.

### Model

O Model representa os dados e as regras da aplicação. No AndroidRunner, isso inclui modelos como:

- `Obstacle`
- `HitBox`
- Tipos de coletáveis.
- Regras de física.
- Regras de colisão.

### Por que utilizar MVVM?

Porque permite:

- Separar interface e comportamento.
- Melhorar a organização.
- Facilitar a manutenção.
- Reduzir o acoplamento.
- Criar testes automatizados.
- Evoluir funcionalidades com menor impacto.

---

## 3. Clean Architecture e separação de responsabilidades

O AndroidRunner aplica princípios de **Clean Architecture** para organizar as regras do jogo e evitar dependências desnecessárias entre as partes. A principal ideia é que regras importantes não dependam diretamente da tecnologia utilizada para desenhar a interface.

### Exemplo

Imagine que seja necessário aumentar a força do salto. A alteração deve acontecer na lógica física. Não deve exigir modificações na tela de Ranking, no botão de pausa ou nos componentes visuais. Da mesma forma, alterar a imagem do personagem não deveria exigir mudanças nas regras de gravidade.

### Single Responsibility Principle — SRP

O **Princípio da Responsabilidade Única** estabelece que uma classe deve possuir uma responsabilidade principal bem definida.

No AndroidRunner:

| Classe | Responsabilidade |
|---|---|
| `GamePhysics` | Calcular a física do personagem |
| `ObstacleSpawner` | Criar obstáculos |
| `ObstaclePhysics` | Movimentar obstáculos |
| `CollisionDetector` | Detectar colisões |
| `GameViewModel` | Coordenar a partida |
| `GameUiState` | Representar o estado do jogo |

Essa divisão evita classes excessivamente grandes e facilita os testes.

---

## 4. Game Engine: o motor do jogo

O **Game Engine** é o conjunto de regras que controla o funcionamento da partida. No AndroidRunner, o motor foi desenvolvido em Kotlin. Ele não depende de uma engine externa de jogos.

### GameConstants

Centraliza constantes utilizadas pelo jogo. Exemplos de informações que podem ser controladas por constantes:

- Gravidade.
- Velocidade do salto.
- Velocidade inicial dos obstáculos.
- Intervalo entre obstáculos.
- Limites de movimentação.

**Responsabilidade:** evitar valores importantes espalhados por diferentes classes.

### GamePhysics

Responsável pelos cálculos relacionados ao personagem. Considera:

- Posição vertical.
- Velocidade vertical.
- Gravidade.
- Tempo transcorrido.
- Contato com o chão.

**Responsabilidade:** calcular o movimento do personagem.

### ObstacleSpawner

Responsável pela criação de obstáculos.

**Responsabilidade:** determinar quando um novo obstáculo deve aparecer.

### ObstaclePhysics

Responsável pelo deslocamento dos obstáculos. **Responsabilidade:** atualizar a posição dos obstáculos durante a partida.

### CollisionDetector

Responsável por verificar contatos entre elementos do jogo. **Responsabilidade:** identificar colisões entre personagem, obstáculos e coletáveis.

### Por que separar essas classes?

Porque criar, movimentar e verificar colisões são responsabilidades diferentes. Essa separação facilita ajustes e testes individuais.

---

## 5. Game Loop

O **Game Loop** é o ciclo responsável por manter o jogo funcionando. Durante uma partida, o aplicativo precisa atualizar continuamente as posições dos elementos e verificar o que acontece no cenário.

### Etapas de uma atualização

1. Receber uma atualização de frame.
2. Calcular o tempo transcorrido.
3. Atualizar a física do personagem.
4. Movimentar obstáculos.
5. Movimentar coletáveis.
6. Verificar a criação de novos elementos.
7. Detectar colisões.
8. Atualizar a pontuação.
9. Publicar o novo estado.
10. Atualizar a interface.

```text
              NOVO FRAME
                   |
                   v
               DELTA TIME
                   |
                   v
            ATUALIZAR FÍSICA
                   |
                   v
          MOVIMENTAR ELEMENTOS
                   |
                   v
           VERIFICAR COLISÕES
                   |
                   v
           ATUALIZAR PONTOS
                   |
                   v
              GAME UI STATE
                   |
                   v
             JETPACK COMPOSE
                   |
                   v
              PRÓXIMO FRAME
```

### O que é Delta Time?

Delta Time representa o intervalo de tempo entre duas atualizações. Em uma movimentação simples:

```text
deslocamento = velocidade × tempo
```

Isso permite calcular o movimento considerando o tempo transcorrido, em vez de depender apenas da quantidade de frames processados.

---

## 6. Física do personagem

O salto utiliza conceitos básicos de movimento vertical. Quando o jogador toca na tela, o personagem recebe uma velocidade vertical de salto. A gravidade modifica essa velocidade ao longo do tempo. O personagem sobe, desacelera, começa a descer e retorna ao chão.

### Etapas do salto

```text
         TOQUE NA TELA
                |
                v
      VELOCIDADE DE SALTO
                |
                v
         PERSONAGEM SOBE
                |
                v
      GRAVIDADE DESACELERA
                |
                v
        PERSONAGEM DESCE
                |
                v
        CONTATO COM O CHÃO
```

### Bloqueio de salto duplo

O AndroidRunner impede que o jogador execute outro salto enquanto o personagem ainda está no ar. Essa regra mantém o comportamento consistente com a mecânica planejada.

### Por que separar a física do Compose?

Porque a física é uma regra do jogo. O Compose precisa conhecer a posição que deve apresentar, mas não precisa implementar o cálculo da gravidade. Essa separação facilita manutenção, testes e evolução visual.

---

## 7. Sistema de obstáculos

O sistema de obstáculos possui três responsabilidades principais.

### Criação

O `ObstacleSpawner` controla o aparecimento de novos obstáculos.

### Movimentação

O `ObstaclePhysics` atualiza suas posições horizontais. Os obstáculos se deslocam em direção ao personagem, criando a sensação de corrida contínua.

### Remoção

Quando um obstáculo deixa a área útil do jogo, ele pode ser removido dos elementos ativos. Isso evita manter objetos que não participam mais da partida.

### Colisão

O `CollisionDetector` verifica se o personagem entrou em contato com um obstáculo. Quando ocorre uma colisão válida, a partida é encerrada.

### Dificuldade progressiva

Conforme a pontuação aumenta, o jogo ajusta a velocidade e a frequência de aparecimento dos obstáculos. Isso torna a corrida progressivamente mais desafiadora.

---

## 8. HitBox e detecção de colisões

Uma **HitBox** é uma representação geométrica utilizada para verificar contatos entre objetos. No AndroidRunner, as HitBoxes são retangulares.

```kotlin
data class HitBox(
    val left: Float,
    val top: Float,
    val right: Float,
    val bottom: Float
)
```

### Propriedades

| Propriedade | Significado |
|---|---|
| `left` | Limite esquerdo |
| `top` | Limite superior |
| `right` | Limite direito |
| `bottom` | Limite inferior |

### Como a colisão funciona?

O `CollisionDetector` compara os limites das áreas ocupadas pelos elementos. Quando existe sobreposição, pode ocorrer uma colisão.

### Por que não utilizar diretamente a imagem?

Porque a imagem pode conter áreas transparentes ou detalhes visuais que não devem ser considerados na colisão. Uma HitBox independente permite ajustar a região de contato. Isso melhora o controle da jogabilidade e facilita os testes unitários.

---

## 9. Sistema de coletáveis

Os coletáveis são itens especiais que aparecem durante a corrida e oferecem pontos adicionais. O sistema possui oito tipos.

### Responsabilidades

| Parte | Responsabilidade |
|---|---|
| `CollectibleType` | Definir tipos, pontos e pesos |
| `CollectibleSpawner` | Criar coletáveis |
| `CollectiblePhysics` | Movimentar coletáveis |
| `CollisionDetector` | Identificar o contato com o personagem |
| `GameViewModel` | Coordenar a atualização da pontuação |

### O que é peso de aparecimento?

É um valor utilizado para influenciar a probabilidade de um coletável ser selecionado. Assim, alguns itens podem aparecer com mais frequência do que outros. Esse mecanismo permite controlar a distribuição dos coletáveis durante a partida.

---

## 10. Gerenciamento de estado com StateFlow

O **estado** representa as informações necessárias para descrever a situação atual do jogo. Por exemplo:

- Onde está o personagem?
- Qual é a pontuação?
- Quais obstáculos estão ativos?
- Quais coletáveis estão visíveis?
- A partida está pausada?
- O jogo terminou?

Essas informações são representadas pelo `GameUiState`.

### O que é StateFlow?

`StateFlow` é um fluxo reativo de estado disponibilizado pelas bibliotecas de Coroutines do Kotlin. Ele permite que a interface observe o estado atual e receba atualizações.

### Fluxo de atualização

```text
         GAME VIEWMODEL
                |
                v
         ATUALIZA O ESTADO
                |
                v
             STATEFLOW
                |
                v
          GAME SCREEN
                |
                v
       COMPOSE ATUALIZA A UI
```

### O que é recomposição?

No Jetpack Compose, recomposição é o processo de atualizar a interface quando os dados observados mudam. Por exemplo, quando a pontuação muda, o Compose atualiza sua apresentação. Isso reduz a necessidade de controlar manualmente cada elemento visual.

---

## 11. Eventos e fluxo unidirecional

O AndroidRunner utiliza eventos para representar as ações do jogador. Exemplos:

- Saltar.
- Pausar.
- Retomar.
- Reiniciar.
- Voltar para a Home.

Esses eventos são encaminhados ao ViewModel.

### O que é Unidirectional Data Flow?

É uma abordagem em que eventos e atualizações seguem um caminho previsível.

```text
       INTERAÇÃO
           |
           v
         EVENTO
           |
           v
        VIEWMODEL
           |
           v
      NOVO ESTADO
           |
           v
        INTERFACE
```

A interface apresenta o estado recebido, enquanto o ViewModel coordena as alterações. Isso facilita compreender de onde vêm as mudanças.

---

## 12. Hilt e injeção de dependências

O AndroidRunner utiliza **Hilt** para injeção de dependências.

### O que é uma dependência?

É um objeto necessário para que uma classe execute seu trabalho. Por exemplo, um ViewModel pode precisar de um repositório para consultar o recorde.

### O que é injeção de dependências?

É uma técnica em que uma classe recebe os objetos necessários, em vez de criar diretamente todas as suas dependências.

### Benefícios

- Redução do acoplamento.
- Melhor organização.
- Facilidade para substituir implementações.
- Maior testabilidade.

Durante os testes, por exemplo, um repositório real pode ser substituído por uma implementação falsa.

---

## 13. Repository Pattern

O **Repository Pattern** organiza o acesso aos dados. Um repositório disponibiliza operações de consulta e armazenamento sem exigir que o ViewModel conheça os detalhes da persistência.

### Exemplo conceitual

```text
          VIEWMODEL
              |
              v
           REPOSITORY
              |
        +-----+-----+
        |           |
        v           v
       ROOM      DATASTORE
```

Esse diagrama representa o conceito geral. Cada repositório pode utilizar apenas a fonte de dados necessária.

### Por que utilizar repositórios?

Porque o ViewModel deve coordenar o comportamento da aplicação, não implementar diretamente operações de armazenamento. Essa separação facilita a manutenção e os testes.

---

## 14. Room e DataStore

O AndroidRunner utiliza duas soluções de persistência local.

### Room

O **Room** é uma biblioteca Android utilizada para trabalhar com bancos de dados SQLite. No AndroidRunner, ele é utilizado para armazenar as pontuações do ranking. É adequado para dados estruturados que precisam ser organizados e consultados.

### DataStore

O **DataStore** é utilizado para armazenar informações simples e preferências. No projeto, isso inclui:

- Recorde.
- Som habilitado ou desabilitado.
- Vibração habilitada ou desabilitada.

### Por que utilizar os dois?

Porque o ranking e as preferências possuem necessidades diferentes. O Room atende ao armazenamento estruturado. O DataStore atende a configurações e valores simples.

---

## 15. Navigation Compose

O **Navigation Compose** organiza a navegação entre as telas. O AndroidRunner possui:

- Home.
- Gameplay.
- Ranking.
- Como Jogar.
- Opções.

### RunnerNavHost

O `RunnerNavHost` organiza os destinos disponíveis e o fluxo de navegação.

### Routes

As Routes conectam as telas aos ViewModels e às ações de navegação.

### Benefício

As telas podem permanecer focadas na apresentação, enquanto a navegação fica organizada em uma estrutura própria.

---

## 16. Design System e componentes reutilizáveis

O AndroidRunner utiliza um Design System para manter consistência visual.

### O que é Design System?

É um conjunto organizado de decisões e componentes utilizados na construção das interfaces. Pode incluir:

- Cores.
- Tipografia.
- Botões.
- Fundos.
- Espaçamentos.
- Estilos visuais.

### Por que centralizar?

Imagine que seja necessário alterar a cor principal dos botões. Quando o estilo está centralizado, a mudança pode ser feita no componente ou tema correspondente. Isso evita alterações repetidas em diferentes telas.

### Componentização

Componentização significa dividir a interface em elementos menores. No AndroidRunner, isso inclui:

- Personagem.
- Obstáculos.
- Coletáveis.
- HUD de pontuação.
- Área do jogo.
- Overlay de Game Over.

Cada componente possui uma responsabilidade visual específica.

---

## 17. Estrutura e responsabilidades do projeto

A organização do AndroidRunner separa funcionalidades e responsabilidades. Abaixo estão os principais elementos da arquitetura.

| Área | Responsabilidade |
|---|---|
| `core` | Recursos compartilhados |
| `game` | Funcionalidades e regras da partida |
| `home` | Tela inicial e seu comportamento |
| `navigation` | Navegação entre telas |
| `ui/designsystem` | Componentes e estilos compartilhados |

### Dentro da feature Game

| Elemento | Responsabilidade |
|---|---|
| `components` | Componentes visuais reutilizáveis |
| `engine` | Regras de física e colisões |
| `events` | Eventos da interface |
| `model` | Modelos utilizados pelo jogo |
| `route` | Conexão entre tela e ViewModel |
| `screens` | Interface principal |
| `state` | Estado da partida |
| `viewmodel` | Coordenação dos eventos e do estado |

### Exemplo: uma ação completa

Quando o jogador toca para saltar:

```text
1. GameScreen recebe o toque
               |
               v
2. GameUiEvent representa a ação
               |
               v
3. GameViewModel recebe o evento
               |
               v
4. GamePhysics calcula o movimento
               |
               v
5. GameUiState recebe a nova posição
               |
               v
6. StateFlow publica o estado
               |
               v
7. GameScreen apresenta o personagem
```

Esse exemplo demonstra a separação entre apresentação, coordenação e regra de jogo.

---

## 18. Testes automatizados

O AndroidRunner possui **20 testes unitários aprovados**.

| Classe | Quantidade | Responsabilidade |
|---|---:|---|
| `GamePhysicsTest` | 3 | Física e movimentação |
| `CollisionDetectorTest` | 5 | Detecção de colisões |
| `CollectibleTypeTest` | 1 | Pontuação dos tipos de coletáveis |
| `GameViewModelTest` | 11 | Estado e eventos da partida |
| **Total** | **20** | |

### O que é um teste unitário?

É um teste que verifica o comportamento de uma unidade de código de forma isolada. Por exemplo, um teste de física pode verificar se o personagem retorna corretamente ao chão.

### Por que testar a física separadamente?

Porque não é necessário abrir o aplicativo e jogar uma partida inteira para validar um cálculo. Isso torna os testes mais rápidos e previsíveis.

### O que são Fake Repositories?

São implementações simplificadas utilizadas durante os testes. Elas permitem controlar os dados retornados e verificar o comportamento do ViewModel sem depender de um banco de dados real.

### Executando os testes

```bash
./gradlew testDebugUnitTest
```

Relatório:

```text
app/build/reports/tests/testDebugUnitTest/index.html
```

A suíte foi executada com sucesso durante o desenvolvimento.

---

## 19. Como estudar o código do AndroidRunner

Para quem deseja conhecer a implementação, esta é uma sequência recomendada.

| Ordem | Classe ou área | O que observar |
|---|---|---|
| 1 | `RunnerNavHost` | Como as telas se conectam |
| 2 | `HomeScreen` e `GameScreen` | Como a interface é construída |
| 3 | `GameUiEvent` | Quais ações o jogador pode executar |
| 4 | `GameUiState` | Quais informações representam a partida |
| 5 | `GameViewModel` | Como eventos e estado são coordenados |
| 6 | `GamePhysics` | Como salto e gravidade funcionam |
| 7 | `ObstacleSpawner` | Como obstáculos são criados |
| 8 | `ObstaclePhysics` | Como obstáculos se movimentam |
| 9 | `CollisionDetector` | Como colisões são identificadas |
| 10 | Repositórios | Como os dados são acessados |
| 11 | Room e DataStore | Como informações são armazenadas |
| 12 | Testes unitários | Como comportamentos são validados |

Essa sequência começa pela interface e avança gradualmente até as regras internas.

---

## 20. Principais decisões técnicas

| Decisão | Benefício |
|---|---|
| Separar física e UI | Permite alterar o visual sem reescrever as regras |
| Utilizar MVVM | Organiza apresentação e comportamento |
| Utilizar StateFlow | Mantém a interface sincronizada com o estado |
| Criar componentes reutilizáveis | Reduz repetição de código |
| Utilizar Hilt | Facilita o gerenciamento de dependências |
| Utilizar repositórios | Isola detalhes da persistência |
| Utilizar Room | Organiza os dados do ranking |
| Utilizar DataStore | Persiste recorde e preferências |
| Criar testes unitários | Ajuda a prevenir regressões |
| Utilizar Delta Time | Melhora a consistência da movimentação |
| Utilizar HitBoxes | Permite ajustar colisões independentemente das imagens |

---

# Tecnologias utilizadas

| Tecnologia | Aplicação |
|---|---|
| Kotlin | Linguagem principal |
| Android Nativo | Plataforma |
| Jetpack Compose | Construção das interfaces |
| Material 3 | Componentes e estilos |
| MVVM | Organização arquitetural |
| ViewModel | Gerenciamento de estado |
| StateFlow | Fluxo reativo de dados |
| Coroutines | Operações assíncronas |
| Navigation Compose | Navegação |
| Hilt | Injeção de dependências |
| Room | Banco de dados local |
| DataStore | Preferências e recorde |
| JUnit | Testes unitários |
| Coroutines Test | Testes de código assíncrono |
| Gradle | Build e dependências |

---

# Testes automatizados

O AndroidRunner possui uma suíte de **20 testes unitários aprovados**.

Os testes verificam:

- Movimento e salto.
- Aterrissagem.
- Colisões.
- Pontuação definida para os coletáveis.
- Pontuação por tempo.
- Pausar e retomar.
- Reiniciar.
- Bloqueio de salto duplo.
- Game Over.
- Preservação do recorde.

Para executar:

```bash
./gradlew testDebugUnitTest
```

O relatório HTML é gerado em:

```text
app/build/reports/tests/testDebugUnitTest/index.html
```

---

# Como executar

### Pré-requisitos

- Android Studio.
- Android SDK configurado.
- JDK compatível com o projeto.
- Emulador Android ou dispositivo físico compatível.

### 1. Clone o repositório

```bash
git clone https://github.com/DeniseLeandroDeCastro/android-runner.git
```

### 2. Entre na pasta

```bash
cd android-runner
```

### 3. Abra no Android Studio

Abra a pasta do projeto e aguarde a sincronização do Gradle.

### 4. Execute o aplicativo

Selecione um dispositivo ou emulador Android e execute o módulo `app`.

### 5. Execute os testes

```bash
./gradlew testDebugUnitTest
```

---

# Evolução do projeto

O AndroidRunner está sendo desenvolvido de forma incremental.

### Gameplay

- [x] Mecânica de salto.
- [x] Gravidade.
- [x] Game Loop.
- [x] Obstáculos em movimento.
- [x] Diferentes tipos de obstáculos.
- [x] Detecção de colisões.
- [x] Sistema de coletáveis.
- [x] Pontuação dinâmica.
- [x] Dificuldade progressiva.
- [x] Pausa e retomada.
- [x] Game Over.
- [x] Reinício da partida.

### Interface

- [x] Identidade visual própria.
- [x] Personagem original.
- [x] Tela inicial.
- [x] Tela de Gameplay.
- [x] Tela de Ranking.
- [x] Tela Como Jogar.
- [x] Tela de Opções.
- [x] Splash Screen.
- [x] Ícone do aplicativo.

### Persistência

- [x] DataStore.
- [x] Persistência do recorde.
- [x] Room.
- [x] Ranking local.
- [x] Preferências de som e vibração.

### Qualidade

- [x] Arquitetura MVVM.
- [x] Separação entre física e UI.
- [x] Componentes reutilizáveis.
- [x] Injeção de dependências.
- [x] Testes de GamePhysics.
- [x] Testes de CollisionDetector.
- [x] Testes de CollectibleType.
- [x] Testes de GameViewModel.
- [ ] Publicação na Google Play.

---

# Status do projeto

**Em desenvolvimento — preparação para publicação na Google Play.**

O jogo já possui suas principais funcionalidades implementadas e segue recebendo melhorias de estabilidade, qualidade e experiência do jogador.

---

# Autora

### Denise Castro

**Android Developer**

Kotlin • Java • Jetpack Compose • Android Native

O AndroidRunner é um projeto autoral desenvolvido com foco em arquitetura de software, qualidade de código e evolução técnica no ecossistema Android.

---

<div align="center">

### AndroidRunner

**Run • Jump • Keep Going**

*Desenvolvido com Kotlin e Jetpack Compose.*

</div>

