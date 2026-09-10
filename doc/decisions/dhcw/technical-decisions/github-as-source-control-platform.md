# GitHub as Source Control Platform

!!! info

    **Status**: Accepted

    **Level**: 3

    **Proposer**: G Norton

    **Author(s)**: G Norton

    **Stakeholders / Reviewers**: C Collis, D Thorne, D Webb, J Howe, J Henderson, R Hopkins, W Kennedy

    **Updated**: 2026-05-21

## Summary

Digital Health and Care Wales (DHCW) uses Azure Repos, spread across multiple Azure
DevOps (ADO) organisations, as its primary source control platform. This fragmentation makes it
difficult for teams to discover and reuse existing code. GitHub is already being adopted for
new projects and better supports open and collaborative working.

This record proposes GitHub as the standard source control platform for DHCW, with migration
from Azure Repos as a consequence.

Migration timescales will be managed at programme or team level. Related tooling decisions
— such as CI/CD pipelines and project tracking boards — are out of scope.

Publishing code as open source is outside the scope and will be addressed in a separate decision record.

## Drivers

* **Fragmented discoverability**: Code is scattered across multiple Azure DevOps organisations,
  making it hard to find and build on existing work.
* **Organisational direction**: The DHCW Digital Playbook targets 100% migration to GitHub
  within 24 months.
* **Open and collaborative working**: GitHub better supports working openly with internal and
  external partners.
* **Emerging adoption**: GitHub is already the default for new projects. Formalising this avoids
  further fragmentation.

## Options

### 1: GitHub as the standard source control platform

Adopt GitHub as the organisation-wide standard. New codebases default to GitHub;
existing codebases migrate over time.

### 2: Continue with Azure Repos

Retain Azure Repos as the primary platform without consolidation, accepting the ongoing
fragmentation and lack of a single source of truth for codebases.
New projects may continue to use GitHub, but there is no formal standard or migration plan.

### 3: Permit both platforms without a stated preference

Teams choose per-project with no organisation-wide standard.

### 4: Adopt an alternative platform (e.g., GitLab, Bitbucket)

Move to a platform not currently in use. Not under consideration given existing GitHub adoption
and no compelling alternative.

## Options Analysis

### Option 1: GitHub as the standard source control platform

**Pro:**

* Single, discoverable location for all DHCW code.
* Aligns with Digital Playbook migration target.
* Supports open working with internal and external partners.
* Already in use for new projects, reducing change impact.
* Mature pull request and code review tooling.
* Established product team, licencing, and operational support already in place.
* Access to Codespaces and Copilot for AI-assisted development.
* Wider pool of external engineers with GitHub experience.
* Integrates with Azure Pipelines and Azure Boards for teams needing continuity.

**Con:**

* Existing Azure Repos codebases require migration effort and risk.
* Teams tightly coupled to Azure DevOps may need transitional arrangements.
* GitHub has had reliability issues, though core Git operations (push/pull/clone) are less
  affected than Actions and Copilot.

### Option 2: Continue with Azure Repos

**Pro:**

* No migration effort for existing codebases.
* Tight integration with Azure Pipelines and Azure Boards.
* Strong performance against its stated 99.9% uptime Service Level Objective (SLO).

**Con:**

* Perpetuates fragmentation across multiple Azure DevOps organisations.
* Does not align with Digital Playbook direction.
* GitHub adoption will continue regardless, increasing inconsistency.
* Azure DevOps is less widely used in industry, which may affect recruitment and
  retention of engineering talent.

### Option 3: Permit both platforms without a stated preference

**Pro:**

* Maximise a team's freedom to choose tools.

**Con:**

* Does not resolve the discoverability problem — codebases remain scattered.
* Creates an inconsistent developer experience and higher long-term maintenance burden.
* Provides no clear direction for teams planning new work or considering migrations.

## Recommendation

Adopt **GitHub** as the standard source control platform for DHCW.

New codebases should be hosted on GitHub by default. Existing Azure Repos codebases should
migrate, prioritised by development activity and complexity. Migration timescales will be
managed at programme or team level, with the expectation that all codebases will be migrated
within 24 months to align with the DHCW Digital Playbook target.

Where there is a specific, documented justification for retaining a codebase in Azure Repos (for
example, a tightly coupled dependency that cannot be resolved in the near term), an exception may
be agreed with the appropriate governance body.

This record covers **source control hosting only**. Related tooling decisions
— such as CI/CD pipeline tooling and project tracking boards — are out of scope and should be
addressed in separate records if required.

### Consequences

* Pro: Single, discoverable home for all DHCW code.
* Pro: Aligns with the DHCW Digital Playbook target of 100% migration to GitHub.
* Pro: Supports open and collaborative working.
* Con: Existing codebases require migration effort and risk management.
* Other: Related tooling decisions (CI/CD, project tracking) need separate records.
* Other: Practical guidance (including how to handle downtime, repo management and
  account onboarding) should be published in the
  [DHCW Software Engineering Handbook](https://gigcymru.github.io/dhcw-software-engineering-handbook/),
  comparable to existing
  [Azure DevOps handbook](https://gigcymru.github.io/dhcw-software-engineering-handbook/azure-devops-handbook/introduction/)
  content.

### Confirmation

Compliance with this decision should be reinforced through the Technical Design Assurance Group
(TDAG) review process for new work. New projects should be hosted on GitHub by default, and any
proposed exceptions should be documented and reviewed by the appropriate governance body.

The Software Engineering Community of Practice should promote awareness of this decision and
related handbook guidance and training.

In future, product service assessments are expected to include verification of adherence to ADRs
and the Engineering Handbook, providing an additional assurance route.

Migration progress can be tracked against the DHCW Digital Playbook target.

## More Information

* DHCW Digital Playbook (internal) — migration target of 100% codebases to GitHub within 24
  months. Contact the DHCW Digital team for access.
* [DHCW Software Engineering Handbook](https://gigcymru.github.io/dhcw-software-engineering-handbook/)
  — operational guidance for GitHub usage.
* [Azure DevOps Handbook](https://gigcymru.github.io/dhcw-software-engineering-handbook/azure-devops/)
  — existing comparable guidance.
