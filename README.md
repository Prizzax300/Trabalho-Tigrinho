# Detector de Golpes Digitais

Projeto desenvolvido em Java para identificar sinais de risco em mensagens que podem estar relacionadas a golpes digitais.

## Objetivo

O objetivo do projeto é receber uma mensagem digitada pelo usuário e verificar se ela possui características que podem indicar um possível golpe.

## Como funciona

O programa analisa a mensagem procurando quatro tipos de sinais:

- Linguagem de urgência
- Pedido de senha ou código
- Pedido de dinheiro ou Pix
- Presença de links

Cada tipo de sinal encontrado adiciona 1 ponto ao risco da mensagem.

## Regra de negócio

A classificação da mensagem funciona da seguinte forma:

- **0 ou 1 sinal:** Risco baixo
- **2 sinais:** Risco médio
- **3 ou 4 sinais:** Risco alto

Quanto mais sinais forem encontrados, maior será o nível de risco apresentado pelo programa.

## Tecnologias utilizadas

- Java
- Scanner
- Strings
- Estruturas condicionais `if` e `else`
- Métodos
- Terminal

## Exemplo de teste

### Mensagem suspeita

```text
URGENTE! Sua conta será bloqueada.
Clique em https://exemplo.com e informe sua senha.
Depois faça um Pix.
