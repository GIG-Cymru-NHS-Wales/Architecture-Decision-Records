# Format Architecture Decision Records using plaintext Markdown

!!! note "Pending Approval"
    Awaiting approval by DHCW Technical Design Authority

**Status**: proposed  
**Date**: 2025-03-27  
**Governance**: Drafted for DHCW Technical Design Authority (TDA) for approval

## Situation - Context and Problem Statement

* We want to record architecture related decisions for NHS Wales organisations, made via agreed governance mechanisms.
* The **structure** is decided by [Use Architecture Decision Records](../use-architecture-decision-records-and-structure/index.md)
* We need to agree the **format**.

## Background - Decision Drivers

* We want the format to be simple and easy to publish on the internet.
* We want the format to support 'formatting' e.g. headings, bold, italics, lists.
* We don't want any proprietary tools to be required to contribute Architecture Decision Records.
* We want to align with industry standards (not reinvent the wheel).
* We want the selected format to be easily adopted.

## Assessment - Considered Options

* [Markdown](https://commonmark.org/)
* [Microsoft DOCX](https://en.wikipedia.org/wiki/Microsoft_Office_Open_XML)
* [Open Document](https://en.wikipedia.org/wiki/OpenDocument_technical_specification)
* No format – just plaintext

## Recommendation - Decision Outcome

Format Architecture Decision Records as plaintext Markdown documents, using the CommonMark specification.

* Allows for Architecture Decision Records to be created and edited in any text editor, no specific software needed.
* Markdown is easy to learn.
* Markdown supports the basic formatting we need (bold, italics, headings, lists etc.)
* Due to the limitations, it guides us to keep things simple (KISS) and easy to read.
* The CommonMark standard for Markdown is supported by GitHub and many other tools, so widely supported.

!!! tip

    Use [Markdown Lint](https://marketplace.visualstudio.com/items?itemName=DavidAnson.vscode-markdownlint) in Visual Studio  Code to ensure the formatting in documents will work well when publishing/rendering.

### Consequences

* This does require some learning as most staff are familiar with DOCX/Word and may have limited experience of Markdown.
* Markdown limits the formatting of the document (can be seen as a positive) so users may be constrained in presenting information.

## More Information

See [Use Architecture Decision Records and Structure](../use-architecture-decision-records-and-structure/index.md) for the structure of an Architecture Decision Record.
