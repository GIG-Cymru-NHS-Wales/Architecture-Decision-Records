# Use Architecture Decision Records and Structure

!!! note "Pending Approval"
    Awaiting approval by DHCW Technical Design Authority

**Status**: proposed  
**Date**: 2025-03-25  
**Governance**: Drafted for DHCW Technical Design Authority (TDA) for approval

## Situation - Context and Problem Statement

* We want to record architecture related decisions for NHS Wales organisations, made via agreed governance mechanisms.
* We need to agree the **structure** of the records i.e what information a record should contain.

## Background - Decision Drivers

* We want the structure to support both detailed and lightweight records.
* We want to align with industry standards (not reinvent the wheel).
* We want the selected structure to be easily adopted.

## Assessment - Considered Options

The structure utilised by:

* [Michael Nygard's template](http://thinkrelevance.com/blog/2011/11/15/documenting-architecture-decisions) – The first incarnation of the term "Architecture Decision Records" (ADR)
* [MADR](https://adr.github.io/madr/) 4.0.0 – The Markdown Architectural Decision Records
* [Decision record template by Jeff Tyree and Art Akerman](https://github.com/joelparkerhenderson/architecture-decision-record/tree/main/locales/en/templates/decision-record-template-by-jeff-tyree-and-art-akerman) - Used in CapitalOne (regulated industry)
* Other templates listed at <https://github.com/joelparkerhenderson/architecture_decision_record>
* [SBAR](https://en.wikipedia.org/wiki/SBAR) (Situation, Background, Assessment, Recommendation) template - used by DHCW internally and in healthcare generally.
* Formless – No conventions for structure

## Recommendation - Decision Outcome

Adopt an Architecture Decision Record structure with mandatory and optional fields,  taking elements of MADR and aligning it with the existing SBAR structure.

* Allows for structured capturing of any decision.
* The structure is comprehensible and facilitates usage & maintenance.
* It allows varying levels of detail to suit the decision being made.
* Aligns with existing terminology and structure that teams will be familiar with.  
* The structure enables flexibility in format, storage and publishing.

See [Architecture Decision Record Template](../../../design-authority/dhcw/architecture-decision-record-template.md)
