# Multiple Application Instances

!!! Success

    **Decision Made:** 09/05/2025

## Decision Required

How to represent multiple instances of an Application.

## Description

Where a Application has a separate instances for different consumers (e.g. each Health Board has its own instance of an Application ~ such as WelshPAS) we need a way to represent this.

## Decision

There will be a 'generic' representation of the Application in the metamodel and each 'instance' of the Application will be represented as children with a descriptive identified added to the name e.g.

## Rationale

Whilst this adds complexity to the model and will lead to duplication it better represents the reality of the enterprise and the inherent complexity. In addition, it allows relationships that are specific to a particular instance to be modelled.

## Model Diagram

``` mermaid
graph TD
  accTitle: Example WelshPAS Instances Model
  accDescr: Shows an example of the parent/child relationship for WelshPAS where each Health Board has its own instance of the application.
  WelshPAS --> W1["WelshPAS [ABUHB]"]
  WelshPAS --> W2["WelshPAS [BCUHB]"]
  WelshPAS --> W3["WelshPAS [CTM]"]
  WelshPAS --> W4["WelshPAS [...]"]
```
