# Language Plugin Demo for JetBrains IDEs

![Build](https://github.com/Raumo0/language-plugin-demo/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/MARKETPLACE_ID.svg)](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/MARKETPLACE_ID.svg)](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID)

## About This Project

This project is a **demonstration prototype** created as part of our team's application to the **Sui Foundation Grant Program**. The goal is to showcase our technical expertise and understanding of IntelliJ Platform plugin development before building a comprehensive Move language plugin for JetBrains IDEs.

> **⚠️ Important Disclaimer**: This is a proof-of-concept demonstration, not a production-ready plugin. It serves to illustrate basic plugin architecture and our team's capability to deliver a full-featured Move language support for IntelliJ IDEA and other JetBrains IDEs.

## Project Purpose

Our team applied for the Sui Foundation grant to develop professional-grade Move language support for the JetBrains ecosystem. This demo project demonstrates:

- Our understanding of IntelliJ Platform SDK
- Experience with language plugin development
- Technical approach and architecture decisions
- Capability to deliver enterprise-quality developer tools

## Current Demo Features

This prototype currently implements basic language plugin infrastructure:

### Core Language Infrastructure
- **Language Definition**: Move language registration with proper file type association for files `.move`
- **File Type Support**: Custom file type implementation with dedicated Move file icon
- **Grammar and Parser**: Full grammar definition with generated parser for syntax
- **Lexer Integration**: Lexer adapter implementation for tokenization

### Syntax and Visual Features
- **Syntax Highlighting**: Multi-color syntax highlighting with customizable color schemes
- **Color Settings Page**: IDE preferences integration for customizing syntax colors
- **Code Formatting**: Automatic code formatting capabilities with configurable rules
- **Code Style Settings**: Comprehensive code style configuration options

### Developer Experience Features
- **PSI (Program Structure Interface)**: PSI implementation for code analysis
- **Code Annotator**: Real-time code analysis and error highlighting
- **Auto-completion**: Intelligent code completion for language constructs
- **Find Usages**: Symbol usage detection and navigation throughout the codebase
- **Structure View**: Hierarchical code structure visualization in IDE sidebar
- **Structure-Aware Navigation**: Smart navigation bar integration

### Code Quality Tools
- **Commenting Support**: Automatic line and block comment handling
- **Spell Checking**: Integrated spell checking for code comments and strings
- **Refactoring Support**: Foundation for safe code refactoring operations

## Hybrid PSI+LSP Architecture Vision

Our current demo implements basic PSI functionality. For production, we'll architect **clean module interfaces** enabling seamless switching between PSI and LSP providers **depending on features**.


## Installation

- Using the IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "language-plugin-demo"</kbd> >
  <kbd>Install</kbd>
  
- Using JetBrains Marketplace:

  Go to [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID) and install it by clicking the <kbd>Install to ...</kbd> button in case your IDE is running.

  You can also download the [latest release](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID/versions) from JetBrains Marketplace and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

- Manually:

  Download the [latest release](https://github.com/Raumo0/language-plugin-demo/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
