# Welcome to NHS Wales Architecture

This site is a shared home for NHS Wales architectural knowledge, decisions,
and principles. It is maintained by [Digital Health and Care Wales (DHCW)](https://dhcw.nhs.wales/).

## NHS Wales and Organisation-Specific Content

Content on this site is organised into two levels, reflected throughout the
navigation:

- **NHS Wales** - National content, approved by the
  [NHS Wales Standards and Architecture Group (SAG)](design-authority/nhs-wales/sag-terms-of-reference.md),
  for adoption across all of NHS Wales.
- **Organisation** - Local content maintained by an individual NHS Wales
  organisation, including its own rationale, implications, and governance.
  Today, this is limited to [DHCW](https://dhcw.nhs.wales/); almost everything
  on this site currently falls under this DHCW-specific level.

## What You'll Find Here

### Architecture Principles

Our [Architecture Principles](principles/dhcw/index.md) guide how we design and build
systems across NHS Wales. The foundational principles are
[approved nationally by SAG](principles/nhs-wales/architecture-principles.md);
DHCW then adopts them, adding its own rationale and implications, and
supplements them with DHCW-specific principles covering areas including:

- User-Centred Design
- Security and Identity
- Cloud and Infrastructure
- Digital Products and Software Engineering
- Data and Analytics
- Open Architecture

### Design Authority

The [NHS Wales Standards and Architecture Group (SAG)](design-authority/nhs-wales/index.md)
is the national body with authority to approve architecture principles,
standards, and decisions for use across NHS Wales.

The [DHCW Technical Design Authority](design-authority/dhcw/index.md) (TDA) adopts
SAG's national principles and oversees DHCW's own architectural decisions,
ensuring alignment with DHCW's and wider NHS Wales's strategic objectives.
You'll find:

- Our ADR process and templates
- Terms of reference
- Meeting records and decisions
- Enterprise architecture metamodel

### Architecture Decisions

We use Architecture Decision Records (ADRs) to document important architectural
choices, including their context, consequences, and rationale. This
documentation helps teams understand not just what was decided, but why those
decisions were made. Decisions published here are currently DHCW-specific.

Our decisions are organised into three categories:

- **Meta Decisions**: Decisions about our ADR process itself, documentation
  standards, and tooling
- **Process Decisions**: Decisions about how we work, including security
  processes, development workflows, and operational procedures
- **Technical Decisions**: Technology choices, system architectures, integration
  patterns, and infrastructure decisions

## Getting Started

1. New to ADRs? Read [why we write architecture decision records](https://github.blog/engineering/architecture-optimization/why-write-adrs/)
   and this [practical overview of ADRs](https://ctaverna.github.io/adr/)

2. Want to propose a new architecture decision? Follow our [ADRProcess](design-authority/dhcw/architecture-decision-record-process.md)

3. Looking for guidance? Start with our [Architecture Principles](principles/dhcw/index.md)

4. Need to review past decisions? Browse our [Categorised decisions](decisions/dhcw/index.md)

## Contributing

This site is managed through our **internal** [GitHub repository](https://github.com/GIGCymru/architecture-internal).
We welcome contributions from the NHS Wales technology community.

Feel free to raise an [Issue](https://github.com/GIGCymru/architecture-internal/issues) to start
a discussion.

See also our [ADR process](design-authority/dhcw/architecture-decision-record-process.md)
documentation for details on how to propose or contribute new decisions.

!!! note "Public and Internal Repositories"

    Note that DHCW maintains both an **internal** repository for development and a
    **public** read-only repository for the published site. Consult the 
    [README](https://github.com/GIGCymru/architecture#readme) for more details.
