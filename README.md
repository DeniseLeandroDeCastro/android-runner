<div>

<img width="2048" height="768" alt="AndroidRunner_ Corrida no Deserto" src="https://github.com/user-attachments/assets/4070fce4-c60c-4f13-9cd9-4e42f8f50f9c" /> <br>


<div align="center">

<img width="376" height="700" alt="image" src="https://github.com/user-attachments/assets/7e703a56-a3a0-4adb-bb81-81a5d19e91a3" />



<img width="376" height="700" alt="image" src="https://github.com/user-attachments/assets/3e881eb8-77a1-4d23-acea-e7c19ba17b9e" />


</div>

#  AndroidRunner

###  Um Endless Runner desenvolvido com Android Nativo

**Kotlin • Jetpack Compose • MVVM • StateFlow • Clean Architecture**

<br>

 Um jogo Android construído do zero, com foco em arquitetura, componentização,
 gerenciamento de estado, física, colisões e uma UI moderna desenvolvida com Jetpack Compose.

<br>

![Android](https://img.shields.io/badge/Android-Native-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-2.2.10-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-UI-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Architecture](https://img.shields.io/badge/Architecture-MVVM-0A66C2?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Em%20desenvolvimento-F5B700?style=for-the-badge)

</div>

---

##  Sobre o AndroidRunner

O **AndroidRunner** é um jogo mobile no estilo **Endless Runner**, desenvolvido nativamente para Android utilizando **Kotlin e Jetpack Compose**.

No jogo, o jogador controla um personagem inspirado no universo Android, que precisa continuar avançando enquanto desvia dos obstáculos encontrados pelo caminho.

O projeto nasceu com um objetivo que vai além da construção de um jogo: criar uma aplicação Android completa, organizada e evolutiva, aplicando conceitos utilizados no desenvolvimento profissional de aplicações mobile.

Desde o início, o projeto foi estruturado pensando em:

- separação de responsabilidades;
- arquitetura MVVM;
- componentes reutilizáveis;
- gerenciamento de estado;
- baixo acoplamento;
- testabilidade;
- manutenção;
- escalabilidade;
- responsividade;
- experiência visual.

A física, os obstáculos e as colisões não ficam acoplados aos componentes do Jetpack Compose. A UI recebe estado e renderiza o jogo, enquanto as regras permanecem separadas.

---

##  Gameplay

O conceito do AndroidRunner segue a mecânica clássica de um **Endless Runner**.

O personagem permanece em uma região da tela enquanto os obstáculos se deslocam em sua direção, criando a sensação de corrida contínua.

O jogador precisa tocar na área do jogo no momento certo para saltar:

```text
                         █
                         █
     🤖                  █
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          TAP
           ↓
        🤖
       ↗  ↘
                         █
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
```

Se o personagem atingir um obstáculo, a partida termina e o jogador pode iniciar uma nova tentativa ou retornar à tela inicial.

---

## ✨ Funcionalidades implementadas

###  Home

- Tela inicial responsiva
- Identidade visual própria
- Exibição de recorde
- Botão principal para iniciar uma partida
- Menu para futuras funcionalidades
- Navegação utilizando Navigation Compose
- Componentes reutilizáveis
- Previews para diferentes tamanhos de tela

###  Gameplay

- Game loop baseado em frames
- Movimento contínuo dos obstáculos
- Mecânica de salto
- Gravidade
- Velocidade vertical
- Bloqueio de pulo duplo
- Pause e Resume
- Spawn contínuo de obstáculos
- Remoção de obstáculos fora da tela
- Controle independente do tempo entre spawns

###  Sistema de colisão

O projeto possui um sistema próprio de detecção de colisões utilizando **HitBoxes**.

As áreas de colisão são independentes das imagens utilizadas na interface.

Isso significa que:

```text
Imagem do personagem
        ≠
Área de colisão
```

Essa abordagem permite calibrar a experiência do jogo sem depender diretamente do tamanho ou das áreas transparentes dos assets.

###  Game Over

- Detecção de colisão
- Interrupção do game loop
- Overlay de Game Over
- Exibição da pontuação
- Exibição do recorde
- Reinício completo da partida
- Retorno para Home

---

#  Arquitetura

O AndroidRunner foi estruturado utilizando **MVVM**, gerenciamento de estado unidirecional e separação entre UI e regras do jogo.

```text
                         ┌──────────────────┐
                         │      UI          │
                         │ Jetpack Compose  │
                         └────────┬─────────┘
                                  │
                             UI Events
                                  │
                                  ▼
                         ┌──────────────────┐
                         │      Route       │
                         └────────┬─────────┘
                                  │
                                  ▼
                         ┌──────────────────┐
                         │    ViewModel     │
                         └────────┬─────────┘
                                  │
                             StateFlow
                                  │
                                  ▼
                         ┌──────────────────┐
                         │   GameUiState    │
                         └────────┬─────────┘
                                  │
                                  ▼
                         ┌──────────────────┐
                         │      Screen      │
                         └──────────────────┘
```

---

##  Fluxo de estado

A interface não altera diretamente o estado da partida.

Os eventos seguem um fluxo previsível:

```text
USER
 │
 │ Tap
 ▼
GameScreen
 │
 ▼
GameUiEvent
 │
 ▼
GameRoute / GameViewModel
 │
 ▼
Game Engine
 │
 ▼
GameUiState
 │
 ▼
StateFlow
 │
 ▼
GameScreen
```

Exemplo durante um salto:

```text
Usuário toca na tela
        ↓
JumpClicked
        ↓
GameViewModel
        ↓
GamePhysics
        ↓
playerVelocityY
        ↓
playerY
        ↓
GameUiState
        ↓
Compose recompõe a posição
```

---

#  Game Engine

Uma das principais decisões do projeto foi manter as regras do jogo independentes da camada visual.

A pasta `engine` concentra as principais regras responsáveis pelo funcionamento da partida.

```text
engine/
│
├── GameConstants.kt
├── GamePhysics.kt
├── ObstaclePhysics.kt
├── ObstacleSpawner.kt
└── CollisionDetector.kt
```

---

##  Game Loop

O jogo possui atualização baseada nos frames disponibilizados pelo Compose.

```text
FRAME
  │
  ▼
Delta Time
  │
  ▼
GameViewModel.updateGame()
  │
  ├───────────────┐
  ▼               ▼
Player         Obstacles
Physics         Physics
  │               │
  └───────┬───────┘
          ▼
      Collision
       Detection
          │
          ▼
     GameUiState
          │
          ▼
       Compose
```

O uso de **delta time** permite que a movimentação seja calculada de acordo com o tempo transcorrido entre os frames.

---

##  Física do personagem

A lógica do salto está isolada em `GamePhysics`.

Ela é responsável por calcular:

```text
posição vertical
        +
velocidade vertical
        +
gravidade
        ↓
nova posição
```

O personagem possui estados que permitem controlar seu comportamento durante a partida, incluindo:

- posição vertical;
- velocidade vertical;
- estado de salto;
- contato com o chão.

A lógica não depende de `Composable`, `Modifier` ou componentes visuais.

---

##  Sistema de obstáculos

Os obstáculos possuem seu próprio modelo:

```kotlin
data class Obstacle(
    val id: Long,
    val x: Float,
    val width: Float,
    val height: Float
)
```

`ObstacleSpawner` é responsável pela criação.

`ObstaclePhysics` controla o deslocamento.

Durante o game loop:

```text
SPAWN
  ↓
obstáculo aparece à direita
  ↓
move para esquerda
  ↓
atravessa o cenário
  ↓
sai da área visível
  ↓
é removido
```

Novos obstáculos são criados continuamente durante a partida.

---

##  Collision Detection

A detecção de colisão utiliza retângulos lógicos representados por `HitBox`.

```kotlin
data class HitBox(
    val left: Float,
    val top: Float,
    val right: Float,
    val bottom: Float
)
```

O `CollisionDetector` compara a área do personagem com a área de cada obstáculo.

```text
PLAYER HITBOX

     ┌─────────┐
     │         │
     │   🤖    │
     │         │
     └─────────┘
           ↓
     intersection?
           ↑
       ┌───────┐
       │       │
       │   █   │
       │   █   │
       └───────┘

     OBSTACLE HITBOX
```

Essa estratégia também torna a regra de colisão mais fácil de testar isoladamente.

---

#  Estrutura do projeto

A organização atual segue uma abordagem baseada em features e responsabilidades:

```text
br.com.denisecastro.androidrunner
│
├── core
│   └── formatter
│
├── game
│   │
│   ├── components
│   │   ├── area
│   │   ├── character
│   │   ├── gameover
│   │   ├── hud
│   │   ├── obstacles
│   │   └── world
│   │
│   ├── engine
│   │   ├── CollisionDetector.kt
│   │   ├── GameConstants.kt
│   │   ├── GamePhysics.kt
│   │   ├── ObstaclePhysics.kt
│   │   └── ObstacleSpawner.kt
│   │
│   ├── events
│   │   └── GameUiEvent.kt
│   │
│   ├── model
│   │   ├── HitBox.kt
│   │   └── Obstacle.kt
│   │
│   ├── route
│   │   └── GameRoute.kt
│   │
│   ├── screens
│   │   └── GameScreen.kt
│   │
│   ├── state
│   │   └── GameUiState.kt
│   │
│   └── viewmodel
│       └── GameViewModel.kt
│
├── home
│   ├── components
│   ├── events
│   ├── route
│   ├── screens
│   ├── state
│   └── viewmodel
│
├── navigation
│   ├── RunnerDestination.kt
│   └── RunnerNavHost.kt
│
└── ui
    └── designsystem
        ├── components
        └── theme
```

---

#  Design System

O AndroidRunner possui uma camada própria de **Design System**.

Ela concentra elementos visuais compartilhados pelo aplicativo, evitando cores, estilos e componentes espalhados pelas features.

```text
ui/designsystem
│
├── components
│   ├── background
│   └── button
│
└── theme
    ├── Color.kt
    ├── Theme.kt
    └── Type.kt
```

Entre os componentes compartilhados estão:

- backgrounds;
- botões;
- cores;
- tipografia;
- identidade visual.

Isso permite manter Home, Gameplay e futuras telas visualmente consistentes.

---

#  Jetpack Compose Previews

Os componentes visuais são desenvolvidos com **Previews**, permitindo validar a interface sem precisar executar o aplicativo a cada alteração.

Exemplos:

```text
HomeScreenPreview
GameScreenPreview
GameScreenGameOverPreview
GameHudPreview
GameObstaclePreview
RunnerCharacterPreview
GameOverOverlayPreview
```

Também são considerados diferentes tamanhos de tela para melhorar a responsividade da interface.

---

#  Stack

| Tecnologia | Utilização |
|---|---|
| **Kotlin** | Linguagem principal |
| **Android Native** | Plataforma |
| **Jetpack Compose** | Construção da interface |
| **Material 3** | Componentes e fundamentos visuais |
| **ViewModel** | Gerenciamento de estado |
| **StateFlow** | Fluxo reativo de estado |
| **Coroutines** | Execução assíncrona e integração com o ciclo da aplicação |
| **Navigation Compose** | Navegação entre telas |
| **Compose Preview** | Desenvolvimento e validação visual |
| **Gradle** | Build e gerenciamento de dependências |


#  Roadmap

O AndroidRunner continua em desenvolvimento.

###  Gameplay

- [x] Mecânica de salto
- [x] Gravidade
- [x] Game loop
- [x] Obstáculos em movimento
- [x] Spawn contínuo
- [x] Hitboxes
- [x] Detecção de colisão
- [x] Pause / Resume
- [x] Game Over
- [x] Restart
- [ ] Pontuação dinâmica
- [ ] High Score
- [ ] Aumento progressivo de dificuldade
- [ ] Diferentes tipos de obstáculos

###  Visual

- [x] Identidade visual inicial
- [x] Design System
- [x] UI responsiva
- [x] Compose Previews
- [ ] Animação de corrida
- [ ] Animação de salto
- [ ] Cenário em camadas
- [ ] Parallax
- [ ] Novos assets
- [ ] Efeitos visuais

###  Dados

- [ ] Persistência do High Score
- [ ] DataStore
- [ ] Histórico de partidas

###  Qualidade

- [ ] Testes de `GamePhysics`
- [ ] Testes de `CollisionDetector`
- [ ] Testes de `ObstacleSpawner`
- [ ] Testes de ViewModel
- [ ] Testes de UI com Compose

###  Novas telas

- [ ] Ranking
- [ ] Como Jogar
- [ ] Configurações

---

#  Como executar

### Pré-requisitos

Para executar o projeto, utilize:

- Android Studio
- Android SDK configurado
- JDK compatível com o projeto
- Emulador Android ou dispositivo físico

### Clone o projeto

```bash
git clone https://github.com/DeniseLeandroDeCastro/android-runner
```

Entre na pasta:

```bash
cd AndroidRunner
```

Abra o projeto no **Android Studio**, aguarde a sincronização do Gradle e execute o módulo `app`.

---

#  Objetivos técnicos

Além da implementação do jogo, este projeto é utilizado para aprofundar conceitos importantes do desenvolvimento Android, entre eles:

```text
✔ Arquitetura MVVM
✔ StateFlow
✔ Unidirectional Data Flow
✔ Jetpack Compose
✔ Componentização
✔ Design System
✔ Navigation Compose
✔ Game Loop
✔ Delta Time
✔ Física básica
✔ Collision Detection
✔ Gerenciamento de estado
✔ Responsividade
✔ Testabilidade
✔ Clean Code
```

---

#  Status do projeto

  **Em desenvolvimento**

O AndroidRunner está sendo desenvolvido de forma incremental.

Cada nova funcionalidade é implementada procurando preservar a separação de responsabilidades e a possibilidade de evolução do projeto sem concentrar toda a lógica na camada de UI.

---

#  Autora

<div>

### Denise Castro

**Android Developer**

Kotlin • Java • Jetpack Compose • Android Native

<br>

Desenvolvido com foco em **Android, arquitetura de software, qualidade de código e evolução técnica**.

</div>

---

<div>

###  AndroidRunner

**Run • Jump • Keep Going**

</div>
