# Technical Debt

!!! success "Approved"

    This definition was approved by the DHCW Technical Design Authority (TDA) on
    26/06/2026

## Introduction

Technical debt is an inherent reality of long-lived digital systems. In DHCW,
this spans an estate that ranges from systems built two decades ago to products
being delivered today—each carrying its own form of accumulated compromise,
constraint, or deviation from current best practice.

This document establishes a shared, organisation-wide definition of technical
debt, introduces a taxonomy of debt types relevant to the DHCW context, and
sets out the relationship between technical debt and architecture governance.
Its purpose is to create a common language for identifying, discussing, and
managing technical debt consistently across teams and programmes.

## What Is Technical Debt?

Technical debt is the **accumulated cost of design, implementation, or
governance choices that make a system harder, slower, or more expensive to
change, maintain, or operate than it would otherwise be**—measured against
the organisation's current standards, principles, and architectural direction.

The term originates from Ward Cunningham's 1992 metaphor: like financial debt,
technical debt is not inherently bad. Borrowing against the future can be a
legitimate, strategic choice. The problem arises when debt is unacknowledged,
unmanaged, or allowed to compound without a plan for repayment.

!!! note "Guardrails, Not Jail Cells"

    Not every deviation from a current standard constitutes problematic debt.
    DHCW's architecture governance is designed to set guardrails that guide
    good decision-making, not to enforce rigid conformance at the expense of
    pragmatism.

    A team that consciously deviates from an agreed principle or ADR—with clear
    rationale, documented context, and awareness of the trade-offs—is making a
    **deliberate, managed decision**. This is categorically different from
    unrecognised, untracked debt that silently erodes system quality and
    delivery capacity.

    The distinction between managed and unmanaged debt is the foundation of
    responsible technical stewardship.

---

## The Debt Spectrum: Deliberate vs. Inadvertent

All technical debt falls somewhere on a spectrum between deliberate and
inadvertent.

### Deliberate Debt

Deliberate debt is **knowingly accepted** as a consequence of a specific
decision made in context. This includes:

* A team choosing a faster, simpler solution to meet a delivery deadline, with
    an agreed plan to revisit the approach.
* A new system that temporarily does not conform to an emerging architecture
    standard because the standard has not yet been finalised or is not yet
    practically applicable.
* A legacy system retained beyond its intended lifespan because the risk or
    cost of replacement outweighs the current benefit.
* A decision to not adopt an approved ADR in a specific context because the
    problem or constraints of that context make conformance inappropriate—
    provided this is documented and understood.

Deliberate debt is **expected and acceptable** when it is visible, owned, and
tracked. Teams are encouraged to surface this debt transparently rather than
conceal it.

### Inadvertent Debt

Inadvertent debt arises **without explicit awareness or intent**. It accrues
through:

* Outdated practices that were once current but have since been superseded.
* Knowledge loss, staff turnover, or absence of documentation.
* Incremental shortcuts made under pressure that were never revisited.
* Systems that predate the organisation's current governance frameworks and
    have never been assessed against them.

Inadvertent debt is the most damaging form. It is often invisible until it
causes an incident, a failed change, or an unplanned remediation effort.
Identifying and reclassifying inadvertent debt as deliberate—through
assessment and explicit ownership—is itself a valuable act of management.

---

## Taxonomy of Technical Debt

DHCW recognises the following categories of technical debt. These are not
mutually exclusive; a single system may carry multiple types simultaneously.

### 1. Legacy System Debt

Debt carried by systems that are **aged, unsupported, or built on technology
platforms that no longer align with the organisation's strategic direction**.

This is the most structurally complex category in DHCW's context, where
systems supporting clinical and operational functions may have been in
production for 15 to 20 or more years. Legacy debt is characterised by:

* End-of-life operating systems, frameworks, runtimes, or databases.
* Vendor or community support that has lapsed or is nearing expiry.
* Architectures that are monolithic, tightly coupled, or otherwise resistant
    to change.
* Integration approaches (e.g. point-to-point, proprietary interfaces) that
    predate current open standards.
* Dependency on skills, staff, or knowledge that is scarce or at risk.
* High change risk: even small modifications require disproportionate effort
    or carry significant regression risk.

Legacy debt does not imply that a system should immediately be replaced. It
means the debt is understood, its risk profile is known, and a position on
its management or remediation exists.

### 2. Architectural Conformance Debt

Debt arising from **systems or design decisions that do not conform to
current architecture principles, approved ADRs, or the organisation's
solution architecture strategy**.

This category spans a wide range—from new solutions that bypass agreed
integration standards, to systems that were built before current principles
existed and have not been assessed since.

!!! important "Conformance Debt Is Not Always Problematic"

    A deviation from an architecture principle or ADR is not automatically
    debt. If a team has documented a context-specific rationale—whether through
    a formal ADR exception, a design overview, or equivalent governance
    artefact—the deviation is a deliberate, managed decision.

    Conformance debt arises when the deviation is **undocumented, unreviewed,
    or unacknowledged**. The act of surfacing and documenting the deviation
    converts it from inadvertent to deliberate debt, making it manageable.

Indicators of architectural conformance debt include:

* Systems that do not use approved integration or interoperability standards
    (e.g. HL7 FHIR) where these have been mandated.
* Infrastructure or deployment patterns that conflict with the cloud strategy
    or approved landing zone patterns.
* Solutions built without engagement with the [ADR process](architecture-decision-record-process.md)
    where one was warranted.
* Patterns that set precedents inconsistent with the [Architecture Principles](
    https://gigcymru.github.io/architecture/principles/dhcw/) or emerging blueprints.

### 3. Engineering and Code Debt

Debt embedded in the **implementation quality of a system**, independent of
its architecture. This is the form of technical debt most commonly recognised
in software engineering practice and includes:

* Low or absent automated test coverage, resulting in high regression risk
    and slow delivery.
* Code that is complex, poorly structured, or difficult to understand and
    modify safely.
* Duplicated logic or shared functionality that is replicated rather than
    abstracted.
* Deviation from agreed coding standards, linting rules, or review processes.
* Insufficient logging, observability, or monitoring instrumentation.
* Build, deployment, or release processes that are manual, fragile, or
    poorly documented.

Engineering debt directly affects delivery throughput, defect rates, and the
ability of teams to respond to change.

### 4. Infrastructure and Platform Debt

Debt in the **underlying platforms, hosting environments, and operational
tooling** that support systems and services.

* Infrastructure that is not managed as code, leading to configuration drift
    and reproducibility risk.
* Environments not aligned to agreed cloud strategy or landing zone patterns.
* Absent or immature disaster recovery, backup, or business continuity
    provision.
* Networking, security configurations, or access controls that reflect
    historical decisions rather than current standards.
* Manual operational processes that are candidates for automation.

Infrastructure debt is particularly significant in health and care contexts
where system availability directly affects patient safety and clinical
operations.

### 5. Security and Compliance Debt

Debt arising from **gaps between a system's current security posture and the
standards expected of systems in the DHCW environment**.

* Unresolved vulnerabilities in third-party dependencies, operating systems,
    or application code.
* Authentication or authorisation mechanisms that do not meet current
    standards (e.g. absence of multi-factor authentication, over-permissive
    access controls).
* Data handling practices inconsistent with applicable legislation, including
    UK GDPR and the Data Security and Protection Toolkit requirements.
* Encryption approaches that are outdated or inadequate for the sensitivity
    of data processed.
* Absent or incomplete security testing, threat modelling, or penetration
    testing programmes.

Security and compliance debt carries regulatory and reputational risk that
extends beyond the system itself. It requires prompt identification and a
clear remediation pathway.

### 6. Data and Integration Debt

Debt in **how data is structured, managed, shared, and integrated across
systems**.

* Point-to-point integrations that bypass agreed integration patterns or
    platforms (e.g. the Integration Hub).
* Inconsistent data models, duplicate patient records, or absence of master
    data management.
* Data that is siloed within systems with no accessible, governed pathway
    for sharing or analysis.
* Integrations that use proprietary or deprecated protocols rather than
    open standards.
* Absence of data lineage, quality metrics, or governance for critical
    clinical or operational data assets.

Data and integration debt undermines interoperability, clinical safety, and
the organisation's ability to use data as a strategic asset.

### 7. Knowledge and Documentation Debt

Debt arising from **gaps in the documentation, understanding, and
institutional knowledge** required to safely operate and evolve a system.

* Systems with no current architecture documentation, design rationale, or
    operational runbooks.
* Critical operational knowledge held by a small number of individuals,
    creating key-person dependency and succession risk.
* Absence of decisions records: where architectural choices were made but
    never documented, leaving future teams unable to understand the rationale.
* Onboarding materials that are absent, outdated, or insufficient to bring
    new team members up to working competence.

Knowledge debt is often invisible until the knowledge is lost. It compounds
other forms of debt by making diagnosis, remediation, and safe change
considerably harder.

---

## Relationship to Architecture Governance

Technical debt does not exist in isolation from DHCW's architecture
governance framework. The following governance artefacts directly influence
how debt is created, recognised, and managed.

### Architecture Principles

The [Architecture Principles](https://gigcymru.github.io/architecture/principles/dhcw/)
establish the organisation's expectations for how systems should be designed
and built. Systems that deviate from these principles—without documented
rationale—represent **architectural conformance debt**. Regular assessment of
systems against current principles is a mechanism for identifying inadvertent
debt.

### Architecture Decision Records (ADRs)

An [ADR](architecture-decision-record-process.md) that approves or mandates a
particular approach establishes an organisational expectation. Where systems
do not conform to an approved ADR and no documented exception exists, this
constitutes debt. Conversely, an ADR that explicitly records a deviation—with
its rationale and trade-offs—converts inadvertent conformance debt into
deliberate, managed debt.

Teams are encouraged to use the ADR process proactively to surface and
document deviations, rather than treating non-conformance as something to be
concealed or deferred.

### Solution Architecture Strategy

The solution architecture strategy establishes forward-looking direction for
DHCW's technical estate. Systems that do not align to this direction—whether
due to legacy constraints or recent design choices—represent debt relative to
the strategic target. Assessment against the strategy provides a structured
mechanism for identifying where investment in remediation is most valuable.

---

## Identifying and Managing Technical Debt

Recognising technical debt is a prerequisite for managing it. DHCW teams are
expected to:

**Identify and surface debt openly.** Debt that is visible can be managed.
Debt that is hidden compounds. Teams should maintain a clear, honest picture
of the debt they carry—whether in a backlog, a design overview, or a
programme risk log.

**Classify debt by type and origin.** Using the taxonomy above, teams should
understand what kind of debt they are carrying and whether it is deliberate
or inadvertent. This classification informs prioritisation and the appropriate
remediation approach.

**Distinguish between debt and a known, accepted position.** Not every gap
from a current standard requires immediate action. A system that is fully
understood, appropriately documented, and carries debt as an accepted
trade-off is in a very different position from one where the debt is unknown
or unacknowledged.

**Assign ownership.** Each item of identified debt should have a named owner
responsible for its tracking and remediation, or for maintaining the
documented position that it is an accepted trade-off.

**Prioritise based on risk and value.** Remediation effort should be directed
where the impact is greatest. Security and compliance debt that creates
patient safety or regulatory risk warrants different urgency than engineering
debt in a stable, low-change system.

**Engage governance early.** Where remediation of technical debt requires
significant architectural change, or where a decision to accept debt sets an
important precedent, the [ADR process](architecture-decision-record-process.md)
or engagement with the Technical Design Assurance Group (TDAG) is appropriate.
