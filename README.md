# 🛒 Shopping Events App

<div align="center">
  <strong>Aplicativo Android em Kotlin e Jetpack Compose para gerenciar eventos de compras e itens</strong>
</div>

<div align="center">
  <img src="https://img.shields.io/badge/Kotlin-yellow?style=for-the-badge&logo=kotlin"/>
  <img src="https://img.shields.io/badge/Jetpack%20Compose-blue?style=for-the-badge&logo=jetpack%20compose"/>
  <img src="https://img.shields.io/badge/Room-lightgrey?style=for-the-badge&logo=sqlite"/>
  <img src="https://img.shields.io/badge/Hilt-purple?style=for-the-badge&logo=dagger"/>
  <img src="https://img.shields.io/badge/Material3-orange?style=for-the-badge"/>
</div>

---

## 📖 Índice

- [🔍 Visão Geral](#-visão-geral)
- [📱 Funcionalidades](#-funcionalidades)
- [📐 Estrutura do Projeto](#-estrutura-do-projeto)
- [🛠️ Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [🚀 Como Executar](#-como-executar)
- [🤝 Contribuição](#-contribuição)
- [📄 Licença](#-licença)

---

## 🔍 Visão Geral

Este aplicativo permite criar e gerenciar **eventos de compras**. Para cada evento, você define um orçamento inicial, data e nome. Dentro de cada evento, é possível adicionar, editar e remover itens de compra, calculando o custo total e organizando suas compras de forma prática.

A aplicação segue o padrão **MVVM** com **Jetpack Compose**, usa **Room** para persistência local e **Hilt** para injeção de dependências.

---

## 📱 Funcionalidades

- Listar eventos de compras com nome, data, orçamento inicial e custo total  
- Criar novo evento de compra via formulário  
- Ao acessar um evento, listar itens associados com nome, quantidade e preço  
- Adicionar e editar itens inline  
- Remover itens via swipe com confirmação  
- Cálculo automático do custo total do evento  
- Navegação entre telas usando Navigation Compose  
- Persistência local de dados com Room  
- Injeção de dependências com Hilt  

---

## 🛠️ Tecnologias Utilizadas

- Kotlin  
- Jetpack Compose (Material3)  
- Room (SQLite)  
- Hilt  
- AndroidX Navigation Compose  

---

## 🚀 Como Executar

1. Clone o repositório:  
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd app-shopping-events
   ```  
2. Abra no Android Studio e sincronize o Gradle.  
3. Execute o app em emulador ou dispositivo físico.

---

## 🤝 Contribuição

1. Fork este projeto  
2. Crie uma branch (`git checkout -b feature/nova-funcionalidade`)  
3. Faça commit (`git commit -m 'feat: descrição da feature'`)  
4. Push (`git push origin feature/nova-funcionalidade`)  
5. Abra um Pull Request  

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE.md para mais detalhes.
