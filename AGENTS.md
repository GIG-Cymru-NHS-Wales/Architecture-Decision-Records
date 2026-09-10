# NHS Wales Architecture Documentation Site

This repository contains the source for the GIG Cymru architecture documentation
website. The following instructions are for an autonomous AI agent to work with
this repository.

## Quick Reference

View all available commands at any time:

```bash
just --list
```

The published documentation is available at: <https://gigcymru.github.io/architecture/>

## Environment Setup

This project uses [Just](https://github.com/casey/just) as a command runner (migrated from Make).

### Prerequisites

- Python 3.13 or higher
- [uv](https://github.com/astral-sh/uv) for package/env management
- [npm](https://github.com/npm/cli) for markdown linting
- [Just](https://github.com/casey/just) for command running
- Git

### Initial Setup

Install the `uv` package manager if not already installed:

```bash
just install
```

Install the required Python packages and sync the environment:

```bash
just sync
```

Install Node.js dependencies for linting:

```bash
npm install
```

### Quick Start (All-in-One)

Run the full setup and start the development server:

```bash
just
```

This will run: install → sync → build → run

## Running Locally

Build the documentation site (output to ./site directory):

```bash
just build
```

Start the local development server (auto-reloads on file changes):

```bash
just run
```

The site will be available at `http://127.0.0.1:8000/`

## Quality Assurance

Run all quality assurance checks (linting, spell checking, and link checking):

```bash
just qa
```

**Important:** Always run quality checks before committing to fix any issues.

### Individual Quality Checks

Run markdown linting only:

```bash
just lint
```

Run spell checking only:

```bash
just spell
```

**Note:** In GitHub Actions PRs, spelling issues are displayed inline in the Files Changed view using the
official `streetsidesoftware/cspell-action` GitHub Action.

Run internal link checking only:

```bash
just check-links
```

Run sync manifest verification only:

```bash
just verify-sync-manifest
```

All of these checks run automatically as part of `just qa` and in the GitHub PR workflow.

## Documentation Structure

- All documentation (in Markdown format) to be published on the site lives under the `doc/` path.
- Markdown documents should adhere to a 120 character line limit, unless it breaks URLs/links/special elements.
- The documentation is built using [Zensical](https://zensical.org/), a modern static site generator.

## Conventions

### Multi-Organisation URL Structure

Content is organised by organisation (e.g. `doc/{section}/nhs-wales/`, `doc/{section}/dhcw/`,
`doc/{section}/phw/`) across `doc/decisions/`, `doc/design-authority/`, and `doc/principles/`, so
published URLs consistently include the org slug. Do not place organisation-specific content
directly under a section root.

### Architecture Decision Records (ADRs)

- ADRs reside under the `doc/decisions/{org}/` path (e.g. `doc/decisions/dhcw/`).
- ADRs should follow the agreed template: `doc/design-authority/dhcw/architecture-decision-record-template.md`
- See `doc/decisions/dhcw/meta-decisions/architecture-decision-records-naming-conventions.md` for naming conventions and rules.

### Architecture Principles

- Architecture Principles reside under the `doc/principles/{org}/` path (e.g. `doc/principles/dhcw/`).

### Diagrams

- Mermaid is used to add diagrams to Markdown files.
- See `doc/decisions/dhcw/meta-decisions/use-mermaid-for-documenting-diagrams.md` for information.

## PR Instructions

Before committing changes:

1. **Always run quality checks:** `just qa` and fix any issues reported
2. **Always run build:** `just build` and fix any WARNINGS raised
3. Test the site locally: `just run` and verify your changes render correctly

## Additional Commands

### Document Conversion

Convert markdown templates to Word documents using Pandoc:

```bash
just word
```

This converts the ADR and design overview templates to `.docx` format.

### Deployment

Build and deploy documentation to GitHub Pages (requires push permissions):

```bash
just deploy
```

The site will be deployed to: <https://gigcymru.github.io/architecture/>

## Development Environment Options

This repository supports multiple development environments:

1. **GitHub Codespaces** (Recommended) - Pre-configured cloud environment
2. **Local Development** - Traditional local setup with uv and npm
3. **Container-based** - Using Podman or Docker
4. **Just-based Workflow** - Modern command runner (current approach)

See the `README.md` for detailed setup instructions for each option.
