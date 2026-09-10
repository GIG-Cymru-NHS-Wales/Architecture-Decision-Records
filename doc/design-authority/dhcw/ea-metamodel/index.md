# Introduction

Our Enterprise Architecture Metamodel provides a structured overview of the
core component types and their relationships within our model.

We are utilising a single shared instance of [Ardoq](https://www.ardoq.com/) to
model the health and care architecture across NHS Wales.

Our metamodel is derived from the [Ardoq Use Case Solutions](https://help.ardoq.com/en/collections/6889-ardoq-use-case-solutions)
and customised the fit the context of NHS Wales. Any deviations from the Ardoq
recommended metamodel are capture as metamodel decisions.

## Decisions

!!! warning

    If a new decision/change is made to the metamodel ensure the metamodel
    diagram here is updated alongside the Gremlin query and associated report
    in Ardoq

The following decisions have been made regarding the metamodel:

* [Multiple Application Instances](multiple-application-instances.md)

## Metamodel Diagram

This is a high-level diagram of the metamodel to aid comprehension, it is a
non-exhaustive view and therefore  doesn't capture every aspect of the model.

``` mermaid
graph TD
  accTitle: Enterprise Architecture Metamodel.
  accDescr: A diagram showing a high level relationships between components in the enterprise architecture metamodel.
  Business_Capability -->|Is Realized By| Application
  Technical_Capability -->|Is Realized By| Application
  Person -->|Belongs To| Organization
  Person -->|Assigned To| Roles
  Person -->|Owns, Is Expert In| Application
  Organisation -->|Own, Supports, Supplies, Consumes| Application
  External_Organisation -->|Supplies| Application
  Application -->|Is Supported By| Database
  Application -->|Accesses / Connects To| Logical_Information
  Application -->|Connects To / Is Supported By / Depends On| Technology_Service
  Infrastructure -->|Is Supported By| Database
  Database -->|Is Located At| Locations
  Technology_Services -->|Is Supported By| Infrastructure
```

!!! tip

    See [Mermaid Docs](https://mermaid.js.org/syntax/flowchart.html) for more
    information on creating/editing these diagrams and the [Mermaid Live Editor](https://mermaid.live/edit).

## Metamodel Compliance Query

A Gremlin query is maintained within Ardoq to produce a "Metamodel Compliance"
report. It will identify any relationships between components that do not match
the agreed metamodel (i.e. non-compliant 'source -> reference -> target'
relationships).

The source for this query is maintained within the ``ea-metamodel-compliance.groovy``
file of this repository, allowing for version control. The contents of the
latest version of this query can be seen below:

``` groovy title="ea-metamodel-compliance.groovy"
--8<-- "doc/design-authority/dhcw/ea-metamodel/ea-metamodel-compliance.groovy"
```
