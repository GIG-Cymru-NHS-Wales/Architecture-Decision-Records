# Architecture Decision Record Process

!!! success "Approved"

    This process was approved by the DHCW Technical Design Authority (TDA) on
    13/06/2025

## Introduction

This document outlines the process for proposing, developing, collaborating
on, and approving Architecture Decision Records (ADRs) within DHCW. The
process emphasises collaboration and working in the open whilst minimising
the involvement of formal governance bodies (e.g. Technical Design Authority
(TDA) and Technical Design Assurance Group (TDAG)) as much as is practicable
whilst maintaining suitable levels of assurance and governance.

!!! important "Public and Internal Repositories"

    DHCW maintains two separate GitHub repositories for architecture:
    
    *   **Internal Repository** (`architecture-internal`): This is where all
        active development, discussions, and reviews occur. **All
        contributions must be made here (unless highly sensitive).**
    *   **Public Repository** (`architecture`): This is a read-only, public-facing
        mirror that is automatically updated from the internal repository.
    
    Content from the internal repository is only synchronized to the public site
    if it is explicitly listed in the `sync-public.toml` manifest.

Anyone can propose an ADR and request collaboration to approve a decision.
The proposal should clearly articulate the problem and context, and may
include a solution or decision if ready. Early engagement is strongly
encouraged, so it is expected proposals will be incomplete and very draft
when first proposed.

There are multiple levels of decision defined, which follow different
processes proportionate to their impact/significance.

!!! success "Template"

    The approved [ADR template](architecture-decision-record-template.md)
    should be used to ensure consistency and completeness.

## Definition of Architecture

For the purposes of the ADR process, **"Architecture"** refers to the
fundamental structures, patterns, and decisions that shape how systems are
designed, built, and evolve over time. Architecture encompasses decisions that
have an impact on:

* **System Structure**: How components, services, or modules are organised and
    interact with each other.
* **Technical Standards**: The selection and use of technologies, frameworks,
    platforms, languages, and tools that form the technical foundation.
* **Integration and Interfaces**: How systems communicate, including APIs, data
    formats, protocols, and integration patterns.
* **Quality Attributes**: Decisions that significantly affect non-functional
    requirements such as performance, scalability, security, reliability,
    maintainability, and accessibility.
* **Cross-cutting Concerns**: Patterns and approaches for logging, monitoring,
    error handling, authentication, authorisation, and other system-wide
    capabilities.
* **Infrastructure and Deployment**: Fundamental choices about hosting, cloud
    platforms, deployment strategies, and operational models.
* **Data Architecture**: How data is structured, stored, accessed, shared, and
    governed across systems.
* **Financial Impact**: Decisions involving significant cost implications,
    including licensing, infrastructure expenses, development effort, training,
    or ongoing operational costs.

### What is NOT Architecture

Following are generally **not** considered architectural decisions for ADR
purposes:

* **Project Management Decisions**: Sprint planning, team organisation, meeting
    schedules, or purely administrative choices.
* **Minor Implementation Details**: Specific variable names, code formatting
    preferences (covered by linters/standards), or localised refactoring within
    a single component that doesn't affect interfaces or patterns.
* **Routine Operations**: Standard deployment of existing patterns, routine
    maintenance tasks, or application of established standards without
    deviation.
* **User Interface Details**: Specific UI/UX design choices that don't affect
    underlying system architecture (e.g., button colours, layout preferences),
    unless they have broader accessibility or technical implications.
* **Temporary Solutions**: Short-lived experiments, proofs of concept, or
    workarounds explicitly marked as temporary and not intended for long-term
    use or broader adoption.
* **Business Process Decisions**: Purely operational or business workflow
    decisions that don't involve technical system changes.
* **Trivial Cost Decisions**: Minor expenses that don't set precedents or
    involve long-term commitments (e.g., one-off small tool purchases).

When in doubt, consider:

* Will this decision constrain or enable future technical choices?
* Will understanding "why" this decision was made be valuable to future teams?
* Does this decision require coordination across multiple teams or systems?
* Are there significant trade-offs, costs, or risks involved?
* Does this decision involve substantial financial commitment or ongoing costs?

If the answer to most of these questions is "yes", it likely warrants an ADR.

## When to Create an ADR

An ADR should be created for decisions that fall within the definition of
"Architecture" as outlined above. The primary purpose is to capture the context
and rationale behind important decisions for future reference and understanding.

Generally, an ADR is justified when a decision:

* Affects the structure of a system or multiple systems.
* Requires coordination or consistency across different teams or projects.
* Impacts the long-term maintainability, scalability, security, or performance
    of a system or service.
* Changes external interfaces or significant internal APIs.
* Involves significant financial implications, including licensing costs,
    infrastructure expenses, or ongoing operational commitments.
* Sets a precedent or establishes a pattern that other teams or projects are
    expected to follow.
* Would benefit future developers, architects, or stakeholders to understand
    the "why" behind the decision.

While the above guidelines cover many scenarios, an ADR is typically **not**
required for:

* Decisions that do not fall into the category of "Architecture" as defined
    above (e.g., purely project management, administrative, or minor UI design
    choices).
* Trivial or routine activities with no lasting architectural impact.
* Decisions fully covered by existing, well-documented standards, policies,
    or established patterns (unless deviating from them).
* Temporary workarounds, short-lived experiments, or proofs of concept
    that are not intended to be permanent architectural components.
* Low-risk, self-contained decisions made by a single developer within a
    project with no impact outside that immediate scope.
* Minor expenses or purchases that don't establish patterns or precedents.

## Initiation and Commissioning

!!! warning "Sensitive Information"

    Sensitive content must **not** be discussed or stored on the **public**
    GitHub repository and **highly sensitive** content shouldn't be stored in
    **ANY** Git repository. Before sharing any information, you must think
    carefully about whether it could be helpful to someone with malicious
    intent.

    See [Public Publication Process](#public-publication-process) and
    [Handling Highly Sensitive ADRs](#handling-highly-sensitive-adrs) for the
    processes to follow.

Prior to the creation of an ADR it is recommended that an [Issue](https://github.com/GIGCymru/architecture-internal/issues)
is raised in the **internal** GitHub repository outlining the need for a new ADR (or
update to an existing one). This enables very early discussion around the
potential ADR with minimal outlay and effort.

Once the proposer wants to move forward with creating/updating an ADR, they are
encouraged to use the standard Git/GitHub workflow and raise a Pull Request
(PR) in the `architecture-internal` repository ahead of following the decision
making process documented here.

??? Tip "Example Git Workflow"

    * Clone the internal repository: `git clone git@github.com:GIGCymru/architecture-internal.git`
    * Create a branch from `main` to work on (see [Naming Conventions](../../decisions/dhcw/meta-decisions/architecture-decision-records-naming-conventions.md)):
      `git checkout main`, `git checkout -b adr/name-of-adr`
    * Make the required changes (add/update files) in your editor of choice.
      (note [the template](architecture-decision-record-template.md))
    * Commit the changes: `git add changed-file.md`, `git commit -m "Added new ADR for x"`
    * Push the changes to GitHub `git push -u origin HEAD`
    * Raise a [Pull Request](https://github.com/GIGCymru/architecture-internal/pulls) on GitHub.com

Notwithstanding the above guidance, the Technical Design Authority (TDA),
Technical Design Assurance Group (TDAG), or other relevant governance bodies
may commission the creation or update of an ADR in specific areas as needed.

## Lifecycle and Status

Each ADR progresses through a lifecycle, and its current state is tracked using
a defined status. This ensures clarity, traceability, and helps manage the
relevance of decisions over time. The `Status` field in the ADR template must
be updated to reflect the current state of the ADR.

The defined statuses are:

* **Proposed**: The initial state of an ADR. It has been drafted and is
    ready for discussion and review.
* **Under Review**: The ADR is actively being discussed and reviewed by
    stakeholders (e.g. via a Pull Request for Level 1, or by a Temporary
    Decision Group for Level 2+). This status indicates the ADR has moved
    past the initial `Proposed` state and is undergoing evaluation before a
    decision is reached.
* **Accepted**: The ADR has been approved by the relevant decision-making
    process (e.g., consensus on a PR, TDG agreement). The decision
    documented is now considered active and should be followed.
* **Rejected**: The proposed decision was reviewed but not approved. The ADR
    is kept for the record of the discussion and outcome.
* **Superseded**: An `Accepted` ADR that has been replaced by a newer ADR.
    The ADR should clearly indicate which ADR supersedes it.
* **Deprecated**: An `Accepted` ADR that is no longer considered relevant or
    best practice. It might be phased out or archived but is not directly
    replaced by a specific new ADR.

The following diagram illustrates the typical lifecycle flow of an ADR:

```mermaid
stateDiagram-v2
    accTitle: ADR Lifecycle State Diagram
    accDescr: A diagram showing the various states and transitions for ADRs
    [*] --> Proposed
    Proposed --> Under_Review : Submitted for discussion / PR raised
    Under_Review --> Accepted : Consensus reached / Approved
    Under_Review --> Rejected : Not approved / Withdrawn
    Accepted --> Superseded : Replaced by new ADR
    Accepted --> Deprecated : No longer current best practice
    Rejected --> [*]
    Superseded --> [*]
    Deprecated --> [*]
```

## Quality and Approval Criteria

For an ADR to be considered "good enough" for approval and merging, it should
meet a set of quality criteria. These criteria ensure that the decision is
well-understood, justified, and provides sufficient context for future
reference.

The following checklist should be considered during the review of an ADR:

* **Clear Problem Articulation:** Is the problem statement, context, and the
  driving factors behind the need for a decision clearly and concisely
  described? (See the **Summary** and **Drivers** sections in the ADR template)
* **Exploration of Alternatives:** Have sufficient and relevant alternative
  solutions been considered and documented? (See the **Options** section.)
* **Documented Rationale and Trade-offs:** Is the chosen solution clearly
  stated, and is the rationale behind the decision well-justified? Are the
  trade-offs (pros, cons, consequences) of the chosen solution and key
  alternatives explicitly documented? (See the **Options Analysis** and
  **Recommendation** sections.)
* **Documented Involvement:** Are the Proposer, Authors, and relevant
  Stakeholders/Reviewers clearly identified in the ADR? (See the metadata
  block in the ADR template.)
* **Financial Implications:** Have the financial implications been adequately
  considered and documented? This includes initial costs, ongoing operational
  expenses, licensing fees, training costs, and any cost savings or avoidance.
  The analysis should cover both direct and indirect costs where relevant.
* **Stakeholder Engagement:** Has feedback from relevant stakeholders been
  sought and incorporated, or is there a rationale if not?
* **Sufficient Context and Linkages:** Does the ADR include necessary
  background information, references to related ADRs, issues (e.g., GitHub
  issues), or other relevant documentation?
* **Completeness and Clarity:** Is the ADR well-written, easy to understand,
  and does it adhere to the [latest ADR template](architecture-decision-record-template.md)?

It is the responsibility of the ADR proposer to strive to meet these criteria.
During the review process (whether via a Pull Request for Level 1 decisions or
within a Temporary Decision Group for higher levels), reviewers and TDG members
are expected to assess the ADR against these quality criteria before
recommending or granting approval.

## Temporary Decision Groups (TDG)

Depending on the level of decision, it may require the formation of a Temporary
Decision Group (TDG). This is a group of volunteers that will ideally have
relevant expertise/experience in the topic area but also may just have an
interest and desire to be involved in the ADR.

When a TDG is utilised, any decision reached by the group is automatically
accepted by the relevant assurance and governance committee.

### Operations and Decision Making

Temporary Decision Groups (TDGs) are formed to collaboratively review and
decide on ADRs, particularly for Level 2 and above. While open to interested
volunteers, ensuring the group possesses the necessary domain expertise is
crucial, especially for higher-level decisions (Level 3 and 4). The proposer
(for Level 2/3) or the TDA (for Level 4) should actively seek participation
from individuals with relevant knowledge and experience when forming the TDG.
The governance body commissioning or reviewing the TDG composition is
responsible for ensuring adequate expertise is represented.

The primary goal of a TDG is to reach **consensus** on the proposed decision.
Consensus means that all members can live with the decision, even if it
wasn't their first choice, and support its implementation. Unanimous
agreement is ideal but not always required; the aim is to avoid significant
unresolved objections.

Disagreements are expected and are a valuable part of the process. TDG
members should engage in open discussion, present evidence, and explore
alternatives to resolve conflicts. If consensus proves difficult to achieve
after thorough discussion and exploration, the TDG should document the
differing viewpoints and the reasons for the disagreement within the ADR.

If a TDG is unable to reach a decision or resolve significant disagreements
within the agreed timeframe, the matter should be **escalated**.

* For Level 2 and 3 decisions, the escalation path is back to the
    **Technical Design Assurance Group (TDAG)**. The TDG presents the
    unresolved issues and differing viewpoints to the TDAG for guidance or
    a final decision.
* For Level 4 decisions, the escalation path is back to the **Technical
    Design Authority (TDA)**, which commissioned the TDG.

## Decision Levels

To ensure the ADR process is proportionate to the impact and scope of a
decision, decisions are categorised into four levels:

!!! Note

    When determining the level, consider also how **easily reversible** the
    decision is (can it be easily stopped, omitted, or undone?) and how
    **easily isolatable** it is (can it run in parallel with similar decisions
    without interference?). Decisions that are hard to reverse and/or hard to
    isolate typically warrant a higher level due to increased risk and
    commitment.

### Level 1: Project-Specific Decisions

* **Scope:** Primarily impacts a single project or a small, closely related
  set of components within a project.
* **Impact:** Minimal impact outside the immediate project team.
* **Characteristics:** Often **easily reversible** and **easily isolatable**.
  The commitment is typically low, allowing for quick trials and adjustments.
* **Examples:** Choice of a specific library within a project, minor
  refactoring decisions, specific implementation details that don't affect
  external interfaces or broader architectural patterns.

### Level 2: Cross-Project/Team Decisions

* **Scope:** Impacts multiple projects or teams, but not necessarily the entire
  organisation.
* **Impact:** Requires coordination or consistency across several teams or
  projects.
* **Characteristics:** May have varying degrees of reversibility and
  isolatability. While potentially more complex to undo or run in parallel
  than Level 1, they are generally less entangled than higher-level decisions.
* **Examples:** Standardising a specific tool or framework used by several
  teams, decisions affecting shared services used by a subset of projects,
  changes to internal APIs consumed by multiple teams.

### Level 3: Organisation-Wide Decisions

* **Scope:** Impacts all projects, teams, or the entire organisation's technical
  landscape.
* **Impact:** Requires broad consensus or mandates organisation-wide
  standards or practices.
* **Characteristics:** Tend to be **harder to reverse** due to broad adoption
  and significant impact if changed. They may also be **harder to isolate**
  as they often establish organisation-wide standards or affect shared
  infrastructure.
* **Examples:** Mandated programming languages, standard architectural
  patterns for all new services, organisation-wide security policies
  affecting technical implementation.

### Level 4: Major/Significant Decisions

* **Scope:** Decisions with significant strategic, technical, or national-
  level implications.
* **Impact:** High risk, high cost, or significant external visibility/
  dependency. May involve external stakeholders or national standards.
* **Characteristics:** Typically **hard to reverse** and **hard to isolate**,
  involving substantial commitment (e.g., financial, training, integration
  effort). These demand the most rigorous review and careful consideration.
* **Examples:** Adoption of a major new cloud platform, significant changes
  to core infrastructure, decisions impacting national data standards or
  interoperability.

## Process by Level

The process for reviewing and finalising an ADR varies by its defined level:

### Level 1: Project-Specific Decisions Process

* **Review Timeframe:** A fixed review timeframe (default **one** week) is set
  for the PR by the proposer and specified in the PRs description.
* **Feedback:** Team members and other relevant peers provide feedback via the
  PR.
* **Approval:** The ADR is merged upon reaching consensus or at the end of the
  review period if no major objections are raised.
* **Notification:** All Level 1 ADRs merged since the last Technical Design
  Assurance Group (TDAG) meeting are added as 'below the line' submissions to
  the TDAG agenda for information.

### Level 2: Cross-Project/Team Decisions Process

* **Flagging:** The proposer flags the ADR to the Technical Design
  Assurance Group (TDAG) agenda as a Level 2 decision.
* **TDG Formation:** The proposer explains the ADR at the TDAG and requests
  volunteers to form a TDG. The TDG must include at least **two** reviewers,
  in addition to the proposer.
* **Review Timeframe:** The proposer, in consultation with the TDG, sets a
  timeframe for discussion and review (default: **two** weeks).
* **Decision:** The TDG collaborates on the ADR and collectively makes the
  decision.
* **Notification:** The finalised ADR and its decision are added to the next
  TDAG agenda for information only.

### Level 3: Organisation-Wide Decisions Process

Level 3 decisions follow the same process as Level 2, but require **five**
members (including the proposer) to form the TDG. In addition to submitting
the agreed decision to TDAG for information, it is also submitted to the
Technical Design Authority (TDA) agenda (below the line) for information
only.

### Level 4: Major/Significant Decisions Process

Level 4 decisions follow the same process as Level 3 but the flagging and
formation of the TDG is handled directly by TDA, bypassing TDAG, although the
outcomes of decisions are shared with TDAG for information.

## Roles and Responsibilities

Clear roles and responsibilities are essential for the effective functioning
of the ADR process. The following outlines key roles and their involvement:

### Stewardship and Maintenance

The overall "stewarding" or "librarianship" of the ADRs, including the
repository, process documentation, template, and ensuring consistency, falls
under the remit of the **ADR Steward**. This role is expected to be a function
within or designated by the Technical Design Assurance Group (TDAG) and/or
Technical Design Authority (TDA).

Once an ADR is **Accepted**:

* The decision it documents becomes a collective agreement.
* The **ADR Proposer** and **ADR Author(s)** are identified in the metadata.
* **Stakeholders / Reviewers** involved in the decision are also recorded in
    the metadata.
* Ongoing maintenance, such as identifying when an ADR might be outdated,
    superseded, or deprecated, is a collective responsibility of the
    architectural community.
* The **ADR Steward**, along with TDAG/TDA, will oversee the health of the
    ADR log and may prompt reviews or updates as needed. Proposers of new,
    related ADRs should also identify existing ADRs that may need to be
    superseded.

### Key Roles

| Role                 | Responsibility           |
| :------------------- | :----------------------- |
| **ADR Proposer**     | Initiates an ADR and leads its development. Presents the ADR to the relevant review body (e.g., via Pull Request, or to a TDG/TDAG/TDA). Responsible for ensuring the ADR meets quality criteria and that all roles are correctly identified in the ADR metadata. |
| **ADR Author**       | Responsible for drafting and updating the content of the ADR. Often the same as the Proposer but can be different individuals. |
| **Stakeholders / Reviewers** | Individuals or groups who have a vested interest in the decision or provide expert review. Their feedback is sought and incorporated into the ADR. For Level 2+ ADRs, this includes the members of the TDG. |
| **TDG Chair**        | (Often the ADR Proposer, or designated for Level 4 TDGs) Facilitates TDG discussions, ensures fair participation, helps track progress towards a decision, and may assist in summarizing the TDG's outcome and updating the ADR. |
| **TDG Members**      | Actively participate in the evaluation, review, and decision-making for Level 2, 3, and 4 ADRs. Contribute expertise, challenge assumptions constructively, and help the TDG reach consensus on the decision. |
| **TDAG**             | Facilitates TDG formation for Level 2 & 3 ADRs. Acts as an escalation point for unresolved disagreements in Level 2 & 3 TDGs. Reviews outcomes of Level 1, 2 & 3 ADRs for information and process adherence. Can commission ADRs. Approves requests for private ADRs (Level 2 & 3). Oversees the ADR process and supports the ADR Steward function. |
| **TDA**              | Commissions and facilitates TDG formation for Level 4 ADRs. Acts as an escalation point for unresolved disagreements in Level 4 TDGs. Reviews outcomes of Level 3 & 4 ADRs for information. Can commission ADRs. Approves requests for private ADRs (Level 4). Provides ultimate governance oversight for the ADR process and supports the ADR Steward function. |
| **ADR Steward**      | (A function likely performed by TDAG/TDA secretariat or a designated individual/team) Owns the ADR repository structure and process documentation. Ensures ADR template compliance, consistency across ADRs, and manages the lifecycle metadata (e.g., status updates in the log). Assists in reporting on ADR activity. |

### Stages, Activities and Owners

| Stage                              | Activities                 | Owner(s)  |
|:-----------------------------------|:---------------------------|:----------|
| **1. Pre-ADR Discussion**          | Raise a GitHub Issue describing the problem or opportunity. | ADR Proposer |
| **2. Drafting the ADR**            | Use template, outline problem, context, options. | ADR Proposer |
| **3. Assigning a Decision Level**  | Determine decision level (1-4) based on scope/impact. | ADR Proposer (reviewed by ADR Steward or TDAG) |
| **4. Pull Request Creation**       | Submit ADR draft as PR in the GitHub repo. | ADR Proposer |
| **5. TDG Formation** (if Level ≥2) | Identify and confirm volunteers, define TDG scope. Update ADR metadata with TDG members as Reviewers. | ADR Proposer, with TDAG or TDA for Level 3/4 |
| **6. Review & Collaboration**      | Drive reviews, manage discussion, gather feedback. | TDG Chair (or Proposer for Level 1) |
| **7. Decision Making**             | Reach consensus, capture rationale, finalise ADR and metadata. | TDG (Chair facilitates), ADR Proposer |
| **8. Approval & Merge**            | Merge PR, assign status (e.g. Approved), label by level | ADR Proposer |
| **9. Publishing (Optional)**       | Request public publication (if suitable). Review by TDAG, Approval by CPTO & CISO. Add to `sync-public.toml`. | ADR Proposer / CPTO / CISO |
| **10. Communication** | Add to TDAG/TDA agenda as needed, broadcast key decisions. | TDAG & TDA Coordinators |
| **11. Lifecycle Management**       | Monitor for relevance, deprecate outdated ADRs. | ADR Steward |

### Approval Authority

The primary role of TDAG and TDA in the context of ADRs that have been through
a Temporary Decision Group (TDG) is one of oversight, process assurance, and
handling escalations, rather than a direct re-approval or veto of a TDG's
consensus decision.

As stated in the "Temporary Decision Groups (TDG)" section, "When a TDG
is utilised, any decision reached by the group is automatically accepted
by the relevant assurance and governance committee."

**TDAG/TDA members** participate in TDGs relevant to their expertise,
contributing to the consensus directly within that forum. Their "approval"
authority is exercised through:

* Commissioning ADRs.
* Defining the scope and level of ADRs.
* Facilitating and ensuring the proper constitution of TDGs (especially
        for Level 3 and 4).
* Acting as the escalation point if a TDG cannot reach consensus.
* Governing the overall ADR process itself.
* Approving exceptions, such as the private ADR process.
* For Level 1 ADRs (which do not use a TDG), the approval is by peer
    consensus on the Pull Request, with TDAG reviewing for information.

## Compliance & Enforcement

Beyond the ADR approval process, TDA and TDAG also play a key role in upholding
the decisions documented in `Accepted` ADRs. Architectural designs and
proposals submitted to TDA/TDAG for review are expected to align with these
decisions.

The ADR template includes a `Confirmation` section for proposers to articulate
this alignment, justify any deviations, and to propose specific methods for
confirming ongoing compliance with the decision.

TDA and TDAG have the authority to challenge or reject submissions that do not
adequately comply with, or justify deviations from, `Accepted` ADRs, thereby
ensuring architectural consistency and adherence to accepted decisions.

Teams need to be proactive in consulting the ADRs and using them as a living
knowledge base of architectural decisions to inform designs and approaches.

## Public Publication Process

The default is to collaborate on ADRs via the DHCW **internal** GitHub
repository unless they are **[highly sensitive](#handling-highly-sensitive-adrs)**.

While many ADRs should eventually be made public to promote transparency, the
internal/public repository split provides a natural control point.

!!! warning "Should this be public?"

    As a general guideline, ADRs shouldn't be made public if they contain
    sensitive information, such as:
    
    * Specific IP addresses or server names.
    * Passwords, secrets, or API keys.
    * Internal network information.
    * Information on security and protection systems (firewalls etc.)
    * Unannounced commercial or strategic information.
    * Personal data or specific staff names (unless agreed).
    * Anything else you think would not be suitable for the public domain.

    Consider if the architecture decision itself can be separated from any
    sensitive information to allow the ADR to be shared.

Explicit approval is required to move an ADR from the **internal** repository
to the **public** repository.

1. **Request for Publication:** The ADR Proposer indicates the intention to
    publish the ADR publicly.
2. **TDAG Review:** ADRs requesting public publication are added to the TDAG
    agenda. TDAG members discuss the suitability for publication and agree on a
    recommendation.
3. **Executive Approval:** The recommendation from TDAG is sent to the Chief
    Products and Technology Officer (CPTO) and the Chief Information Security
    Officer (CISO) for review.
    * Both the CPTO and CISO must review the request.
    * The CISO has the final say on whether an ADR can be published.
4. **Publication:** Upon approval, the ADR is added to the `sync-public.toml`
    manifest and the automated publication process will synchronise the ADR
    with the public repository and site.

### Handling Highly Sensitive ADRs

If a proposed ADR topic is believed to be **highly sensitive** (e.g. information
that would reveal vulnerabilities, disclose critical infrastructure etc.)

* Discussions must occur in a restricted forum, as determined and facilitated
    by the TDA/TDAG (e.g., a private channel, dedicated secure meetings).
* An ADR will still be created using the standard template and will follow the
    standard lifecycle (e.g., Proposed, Accepted).
* However, the ADR itself, containing sensitive details, will be stored in a
    secure, access-controlled location designated by the TDA/TDAG, rather
    than the GitHub repository.

To maintain a degree of transparency and traceability while protecting
sensitive information a placeholder or summary ADR **may** be created in the
internal GitHub repository.

This ADR would typically:

* Indicate that a decision on a sensitive topic has been made and recorded.
* State the ADR title (if the title itself is not highly sensitive).
* Provide a high-level, non-sensitive summary of the decision's scope or
    impact, if possible and appropriate.
* Clearly state that the full details are restricted and stored in a
    secure location due to sensitivity.
* Link to the original generic issue if one was created.
* The decision on whether to create a public placeholder/summary, and the
    level of detail it contains, will be made by the TDA/TDAG, in
    consultation with relevant security and information governance stakeholders.
* The existence of the decision and its status (e.g., Accepted) should still
    be traceable through appropriate governance channels (TDA/TDAG records),
    even if the full content is not publicly accessible.

## General Approach

The TDG (or the original proposer, for less complex ADRs) will conduct
thorough research, analysis, and evaluation of potential solutions or
options. This may involve:

* Gathering additional information and requirements.
* Evaluating different architectural patterns or technologies.
* Assessing the potential risks and benefits of each option.
* Developing prototypes or proof-of-concepts, if necessary.

Throughout the development process, the TDG (or proposer) should actively
seek feedback from relevant stakeholders, including other architects,
developers, operations engineers, and business representatives. This feedback
should be incorporated into the ADR document.

## Appendix - ADR Creation Workflow

The following diagram illustrates the typical end-to-end process for creating
and approving an ADR, from initial idea to a recorded decision.

```mermaid
graph TD
    accTitle: ADR Workflow
    accDescr: Flowchart showing the typical steps for proposing, developing, and deciding on an Architecture Decision Record.

    %% Initialization
    Start(["Start: Identify<br/>need for ADR"]) --> Issue["Optional: Raise Issue<br/>(Internal Repo)"];
    Issue --> Sensitive_Check{"Is content<br/>**Highly Sensitive**?"};

    %% Sensitive Path
    Sensitive_Check -- Yes --> Request_Private["Request Private Process<br/>(TDAG/TDA)"];
    Request_Private --> Private_Auth{"Approved?"};
    Private_Auth -- Yes --> Private_Exec["**Private Process**:<br/>Secure storage &<br/>restricted forum"];
    Private_Auth -- No --> Standard_Init;
    Private_Exec --> Private_Decision["Decision<br/>Reached?"];
    Private_Decision -- Yes --> Placeholder["Optional: Create<br/>Internal Placeholder"];
    Placeholder --> End(["End"]);

    %% Standard Path
    Sensitive_Check -- No --> Standard_Init["**Standard Process**:<br/>Create/Update ADR<br/>in Internal Repo"];
    Standard_Init --> Level_Check{"Decision<br/>Level?"};

    %% Level 1
    Level_Check -- "Level 1" --> Peer_Review["PR Peer Review<br/>(1 week)"];
    Peer_Review --> Consensus_Check{"Consensus?"};

    %% Level 2, 3, 4
    Level_Check -- "Level 2/3" --> Flag_TDAG["Flag to TDAG"];
    Level_Check -- "Level 4" --> Flag_TDA["Flag to TDA"];
    
    Flag_TDAG --> Form_TDG["Form TDG"];
    Flag_TDA --> Form_TDG;
    
    Form_TDG --> Collaborate["TDG Collaboration<br/>(2 weeks)"];
    Collaborate --> Consensus_Check;

    %% Consensus Handling
    Consensus_Check -- No --> Escalate["Escalate to TDAG<br/>(L1-3) or TDA (L4)"];
    Escalate --> Final_Ruling["TDAG/TDA Decision"];
    Final_Ruling --> Merge;
    
    Consensus_Check -- Yes --> Merge["Merge PR &<br/>Update Status<br/>(Accepted/Rejected)"];

    %% Governance & Publication
    Merge --> Notify["Notify TDAG/TDA"];
    Notify --> Pub_Check{"Request Public<br/>Publication?"};

    %% Publication Path
    Pub_Check -- No --> End;
    Pub_Check -- Yes --> TDAG_Rec["TDAG Review &<br/>Recommendation"];
    TDAG_Rec --> Exec_Review["CPTO & CISO<br/>Review"];
    Exec_Review --> CISO_Auth{"CISO<br/>Approves?"};
    
    CISO_Auth -- Yes --> Add_Manifest["Add to<br/>'sync-public.toml'"];
    Add_Manifest --> End;
    CISO_Auth -- No --> End;
```
