# Internal and Public Repository Split

!!! info

    **Status**: Approved
    
    **Level**: 3

    **Proposer**: Chris Collis

    **Authors**: Chris Collis

    **Stakeholders / Reviewers**: Amy Vaughan-Thomas, Andy Shanahan, Dan Thorne, Tim Palmer, Daniel Dwyer-Westwood (ABUHB)

    **Updated**: 2026-02-05

## Summary

DHCW will maintain two separate GitHub repositories to manage architecture
documentation: an **internal** repository (`architecture-internal`) for
development and collaboration, and a **public** repository (`architecture`) for
the published site. A manifest-driven synchronisation workflow will automate
the publishing of selected content to the public domain with ADRs being
explicitly reviewed and approved for publication.

## Drivers

* **Information Governance**: Ensuring that sensitive or draft architectural
  information is vetted before it is published to the public internet.
* **Psychological Safety**: Providing a space where internal staff can
  collaborate on early-stage, incomplete, or experimental documentation without
  the pressure of immediate public visibility.
* **Risk Mitigation**: Reducing the risk of accidental disclosure of
  internal-only infrastructure details, strategic plans, or sensitive metadata.
* **Automation**: Providing a consistent, repeatable, and low-effort process
  for keeping the public-facing documentation in sync with the internal source
  of truth.
* **Transparency**: Maintaining the commitment to "working in the open" by
  ensuring that as much documentation as possible is eventually published.

## Options

1. All documentation is developed and hosted in a single, public repository
   (this is the setup prior to this record).

2. Maintain two repositories (an **internal** and a **public** one) and
   manually copy files when they are ready for release.

3. As per 2. but use an automated synchronisation process to avoid the manual
   overhead, with users explicitly having to choose which files will be made
   public automatically (i.e. via a manifest).

## Options Analysis

### Single Public Repository

**Pro:**

* **Simplicity**: Simplest repository structure with no synchronisation overhead.

**Con:**

* **Risk**: High risk of accidental disclosure.
* **Overhead**: Requires extremely rigorous (and potentially slowing) manual
  vetting of every PR.
* **Chilling Effect**: May discourage early-stage collaboration due to
  immediate public visibility.

### Internal/Public Split

**Pro:**

* **Security & Governance**: Provides a robust control point where content must
  be explicitly opted-in for public release.
* **Collaboration Efficiency**: Internal teams can use standard GitHub
  features (Issues, PRs) for all discussions without worrying about public
  visibility.

**Con:**

* **Process Complexity**: Contributors must work in the internal repository,
  which may be counter-intuitive for those finding the project via the public
  site.
* **Double Storage**: Files are stored in two locations, which can cause
  confusion and is suboptimal.
* **Navigation & Links**: The Zensical navigation configuration and internal
  links can break in the public site if referenced files are excluded from
  synchronisation.

#### Manual Copying

**Con:**

* **Overhead**: Significant manual overhead.
* **Consistency**: Inconsistent updates and high risk of the two repositories diverging over time.

#### Automated Synchronisation (Selected)

**Pro:**

* **Consistency**: Automation ensures that the public repository is a faithful
  mirror of the selected files in the internal repository.
* **Vetting Flow**: The internal PR process serves as the review stage; once
  merged, the sync is automatic.
* **Balance**: Combines the security of a private staging area with the
  efficiency of automated publishing.

**Con:**

* **Tooling Maintenance**: The script and GitHub Actions workflow are new
  components that must be maintained.
* **Initial Cost**: Requires initial investment in synchronisation tooling and
  ongoing maintenance of the sync manifest and scripts.

**Other:**

* Requires a GitHub App or fine-grained PAT with permissions to push to the
  public repository.

## Recommendation

We have decided to implement the **Internal and Public Repository Split with Automated Synchronisation**.
This approach provides the best balance between maintaining our commitment to
transparency and ensuring the security and quality of our architecture
documentation.

The implementation includes:

1. A `sync-public.toml` manifest to define public-safe files.
2. A `scripts/sync-public.py` utility to perform the synchronisation.
3. A GitHub Action workflow `sync-public.yml` to trigger the sync on merges to the `main` branch.
4. A governance process requiring TDAG review and recommendation, followed by
   mandatory approval from the Chief Products and Technology Officer (CPTO) and
   the Chief Information Security Officer (CISO), before any content is added
   to the `sync-public.toml` manifest (see [ADR Process](../../../design-authority/dhcw/architecture-decision-record-process.md)).
5. Technical enforcement of approvals using GitHub `CODEOWNERS` to require
   review from the CPTO for any changes to `sync-public.toml`.

### Consequences

* **Pro**: Increased agility for internal teams to iterate on architecture documentation.
* **Pro**: Significantly reduced risk of sensitive data leaks.
* **Con**: Contributors must be redirected from the public repository to the internal one.
* **Con**: Minor increase in technical complexity to maintain the sync workflow.
* **Con**: Process for publication requires additional overheads and time.

### Confirmation

* TDAG/TDA and the CPTO and CISO will be required to approve ADRs for publication.
* GitHub Branch Protection rules enforce that changes to `sync-public.toml`
  cannot be merged without approval from the designated Code Owner (CPTO).
* The `sync-public` GitHub Action will report success/failure on every merge.
* The `architecture` public GitHub repository will be set to read-only with
  only the automated workflow able to make changes.
