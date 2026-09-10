# Spell

**Status**: first sketch, work in progress, request for collaboration

**Date**: Updated 2025-04-04

**Governance**: Chris & Joel for now because this is so lightweight.

## Context

We want to use a spell check program for our documentation, because it's helpful if there's an automatic spell check step that checks our work for common mistakes.

## Drivers

Broadly, we want use spell programs in many ways to improve quality.

Specifically, we want to add a spell tool:

* Right now.

* Installable locally so we're not sending data elsewhere.

* For VS Code because we both use it

* With a good rating in the VS Code marketplace.

* Focusing on our immediate need for writing markdown.

* With a configuration file that we can check into this git repository.
  
## Assessment

### cspell

<https://cspell.org/>

The CSpell mono-repo, a spell checker for code.

This also offers a cspell command-line application, and related tools.

It's fast and configurable, and the configuration file can be checked into a git repository, such as as a file `cspell.json`, so it's usable by all the people who use the repo with VS Code or any other editor that uses the same file.

It can use custom dictionaries.

### Spelling Checker for Visual Studio Code

<https://marketplace.visualstudio.com/items?itemName=streetsidesoftware.code-spell-checker>

A basic spell checker that works well with code and documents.

The goal of this spell checker is to help catch common spelling errors while keeping the number of false positives low.

This tool leverages cspell as above.

## Recommendation - Decision Outcome

Adopt cspell for right now.

Commit the file `cspell.json` to the top level of this repo.

Revisit if/when a teammate is ready to research if there's something better.
