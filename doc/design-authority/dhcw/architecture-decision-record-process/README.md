# Architecture Decision Record (ADR) Process

This document outlines the process for proposing, developing, collaborating
on, and approving Architecture Decision Records (ADRs) within DHCW. The
process emphasises collaboration and working in the open whilst minimising
the involvement of formal governance bodies (e.g. Technical Design Authority
(TDA) and Technical Design Assurance Group (TDAG)) as much as is practicable
whilst maintaining suitable levels of assurance and governance.

## Overview

Anyone can propose an ADR and request collaboration to approve a decision.
The proposal should clearly articulate the problem and context, and may
include a solution or decision if ready. Early engagement is strongly
encouraged, so it is expected proposals will be incomplete and very draft
when first proposed.

There are multiple levels of decision defined, which follow different
processes proportionate to their impact/significance.

The approved [ADR template](../architecture-decision-record-template.md)
should be used to ensure consistency and completeness.

The default is to collaborate on ADRs via the DHCW public GitHub repository,
in the open. ADRs can be discussed in private by exception if the topic area
is highly sensitive/impacts security etc.

## Initiation Process

Prior to the creation of an ADR it is recommended that an Issue is raised in
this GitHub repository outlining the need for a new ADR (or update to an
existing one). This enables very early discussion around the potential ADR
with minimal outlay and effort.

Once the proposer wants to move forward with creating/update the ADR, they are
encouraged to use the standard Git/GitHub workflow and raise a Pull Request
(PR) ahead of following the decision making process documented here.

??? Tip "Example Git Workflow"

    * Clone this repository: `git clone git@github.com:GIG-Cymru-NHS-Wales/Architecture-Decision-Records.git`
    * Create a branch from `main` to work on (see [Naming Conventions](../architecture-decision-records-naming-conventions.md)):
      `git checkout main`, `git checkout -b adr-for-x`
    * Make the required changes (add/update files) in your editor of choice.
      (note [the template](architecture-decision-record-template.md))
    * Commit the changes: `git add changed-file.md`, `git commit -m "Added new ARD for x"`
    * Push the changes to GitHub `git push -u origin HEAD`
    * Raise a [Pull Request](https://github.com/GIG-Cymru-NHS-Wales/Architecture-Decision-Records/pulls) on GitHub.com

## Temporary Decision Groups (TDG)

Depending on the level of decision, it may require the formation of a Temporary
Decision Group (TDG). This is a group of volunteers that will ideally have
relevant expertise/experience in the topic area but also may just have an
interest and desire to be involved in the ADR.

When a TDG is utilised, any decision reached by the group is automatically
accepted by the relevant assurance and governance committee.

## Decision Levels

To ensure the ADR process is proportionate to the impact and scope of a
decision, decisions are categorised into four levels:

### Level 1: Project-Specific Decisions

* **Scope:** Primarily impacts a single project or a small, closely related
  set of components within a project.
* **Impact:** Minimal impact outside the immediate project team.
* **Examples:** Choice of a specific library within a project, minor
  refactoring decisions, specific implementation details that don't affect
  external interfaces or broader architectural patterns.

### Level 2: Cross-Project/Team Decisions

* **Scope:** Impacts multiple projects or teams, but not necessarily the
  entire organisation.
* **Impact:** Requires coordination or consistency across several teams or
  projects.
* **Examples:** Standardising a specific tool or framework used by several
  teams, decisions affecting shared services used by a subset of projects,
  changes to internal APIs consumed by multiple teams.

### Level 3: Organisation-Wide Decisions

* **Scope:** Impacts all projects, teams, or the entire organisation's
  technical landscape.
* **Impact:** Requires broad consensus or mandates organisation-wide
  standards or practices.
* **Examples:** Mandated programming languages, standard architectural
  patterns for all new services, organisation-wide security policies
  affecting technical implementation.

### Level 4: Major/Significant Decisions

* **Scope:** Decisions with significant strategic, technical, or national-
  level implications.
* **Impact:** High risk, high cost, or significant external visibility/
  dependency. May involve external stakeholders or national standards.
* **Examples:** Adoption of a major new cloud platform, significant changes
  to core infrastructure, decisions impacting national data standards or
  interoperability.

## Decision-Making Process by Level

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
members to form a TDG and in addition to submission of the agreed decision to
TDAG then decisions are also submitted to the Technical Design Authority (TDA)
agenda (below the line) for information only.

### Level 4: Major/Significant Decisions Process

Level 4 decisions follow the same process as Level 3 but the flagging and
formation of the TDG is handled directly by TDA, bypassing TDAG, although the
outcomes of decisions are shared with TDAG for information.

## General Approach to ADRs

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
