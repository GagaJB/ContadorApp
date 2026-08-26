# App Contador - Desenvolvimento Android

**Nome do Aluno:** Gabriel de Jesus Botelho Silva

## Como o Estado funciona neste App
No Jetpack Compose, o estado é a "fonte da verdade" da interface. Ao usar `rememberSaveable { mutableIntStateOf(0) }`, nós dizemos ao Compose para observar essa variável. Quando os botões de soma, subtração ou zerar alteram o valor desse contador, o Compose detecta automaticamente essa mudança e realiza a "recomposição" (recomposition) apenas dos componentes afetados na tela (como o Text e os botões), atualizando a UI imediatamente sem a necessidade de darmos comandos manuais para atualizar o texto.

## Desafios Opcionais Implementados
* **D1:** Impedir que o contador fique negativo. O botão de subtrair é desabilitado (`enabled = contador > 0`) quando o valor chega a 0.
* **D2:** Adição do botão "Zerar" utilizando o estilo visual secundário `TextButton`, que também é desabilitado caso o valor já seja zero.
* **D3:** Preservação do valor do contador na rotação de tela. Foi utilizado o `rememberSaveable` em vez do `remember` comum, mantendo o estado a salvo durante recriações da Activity.
* **D4:** Mudança de cor dinâmica. A cor do número é alterada dependendo da faixa de valor: cor neutra (`onSurface`) quando é 0, e cor de destaque (`primary`) quando é maior que zero.