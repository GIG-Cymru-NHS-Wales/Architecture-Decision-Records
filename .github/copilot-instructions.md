# GitHub Copilot Coding Agent Instructions

This repository contains the NHS Wales Architecture documentation site. These instructions will help you work efficiently with this codebase.

## Repository Overview

This is an **internal** architecture documentation repository for NHS Wales (GIG Cymru). It has:

- A companion **public** repository at <https://github.com/GIGCymru/architecture> (read-only, auto-synced)
- Documentation published to: <https://gigcymru.github.io/architecture/>
- Built using [Zensical](https://zensical.org/), a modern static site generator
- Markdown-based documentation under the `doc/` directory
- Architecture Decision Records (ADRs), principles, and design authority content

## Quick Start

### Environment Setup (Already Done)

The `.github/workflows/copilot-setup-steps.yml` workflow has already installed:

- Python 3.13
- uv package manager
- Just command runner
- Node.js and npm
- All project dependencies

You can immediately start working with the project using the commands below.

### Essential Commands

All commands use `just` (a modern command runner). View all commands with:

```bash
just --list
```

**Most Important Commands:**

```bash
just build          # Build the documentation site
just run            # Start local dev server (http://127.0.0.1:8000)
just qa             # Run ALL quality checks (MUST pass before committing)
just lint           # Lint markdown files only
just check-links    # Check internal links only
```

**Full Workflow:**

```bash
just                # Runs: install → sync → build → run
```

## Development Workflow

### Before Making Changes

1. **Always run quality checks first** to understand the baseline:
   ```bash
   just qa
   ```

2. **Test the build** to ensure no existing issues:
   ```bash
   just build
   ```

### Making Changes

1. **All documentation lives in `doc/` directory**
2. **Markdown files must follow:**
   - 120 character line limit (except URLs/links)
   - markdownlint-cli2 rules (see `.markdownlint-cli2.jsonc`)
   - Internal links must resolve correctly

3. **After changes, ALWAYS run:**
   ```bash
   just build          # Check for build warnings
   just qa             # Run all quality checks
   ```

4. **Test locally before committing:**
   ```bash
   just run            # Start dev server, verify changes render correctly
   ```

5. **Cross-reference related documents:**
   - When making changes to documents under `doc/`, check for relevant related content
   - Add links between related documents to help users navigate
   - Update both documents with reciprocal links where appropriate
   - This improves discoverability and helps users find related information

### Quality Assurance (CRITICAL)

**ALWAYS run `just qa` before committing.** This runs:

1. **Markdown linting** - Validates markdown syntax and style
2. **Internal link checking** - Ensures all internal links resolve
3. **Sync manifest verification** - Validates public sync configuration

These same checks run automatically on PRs and will block merging if they fail.

## Documentation Structure

### Multi-Organisation URL Structure

Content is organised by organisation so URLs are consistent site-wide:

- **NHS Wales** (national) - `doc/{section}/nhs-wales/`
- **DHCW** - `doc/{section}/dhcw/`
- **PHW** - `doc/{section}/phw/`
- Other NHS Wales organisations will follow the same `doc/{section}/{org}/` pattern as they are added

This applies across `doc/decisions/`, `doc/design-authority/`, and `doc/principles/`. Do **not**
place organisation-specific content directly under a section root (e.g. `doc/decisions/*.md`) -
it must sit under the relevant `{org}/` subfolder so the published URL includes the org slug.

### Architecture Decision Records (ADRs)

- **Location**: `doc/decisions/{org}/` (e.g. `doc/decisions/dhcw/`)
- **Template**: `doc/design-authority/dhcw/architecture-decision-record-template.md`
- **Naming conventions**: See `doc/decisions/dhcw/meta-decisions/simplify-architecture-decision-records-structure.md`
- **Structure**: Each ADR is a single Markdown file (not a directory) using kebab-case naming
- **Important**: Always check if an ADR is marked as "Deprecated" or "Superseded" in its status - use the replacement ADR instead

### Architecture Principles

- **Location**: `doc/principles/{org}/` (e.g. `doc/principles/dhcw/`)
- **Examples**: `doc/principles/dhcw/architecture-principles.md`, `doc/principles/dhcw/digital-products-and-software-engineering.md`

### Design Authority

- **Location**: `doc/design-authority/{org}/` (e.g. `doc/design-authority/dhcw/`)
- **Templates**: Decision record and design overview templates
- **Meetings**: Meeting notes in `doc/design-authority/dhcw/meetings/`

### Diagrams

- **Use Mermaid** for diagrams in markdown files
- **Reference**: `doc/decisions/dhcw/meta-decisions/use-mermaid-for-documenting-diagrams.md`

## Configuration Files

### Key Configuration

- **`zensical.toml`** - Site configuration (name, URL, navigation, theme)
- **`justfile`** - Command definitions
- **`pyproject.toml`** - Python dependencies
- **`package.json`** - Node.js dependencies (for linting)
- **`.markdownlint-cli2.jsonc`** - Markdown linting rules
- **`sync-public.toml`** - Public repository sync manifest

### Navigation

Navigation is **explicitly defined** in `zensical.toml` under the `nav` array. Files are not auto-discovered, so:

- **When adding new docs**, update `zensical.toml` navigation
- **When removing docs**, remove from navigation and consider sync manifest

## Public Repository Synchronization

This internal repository syncs selected files to the public repository:

- **Manifest**: `sync-public.toml` - Lists files to sync
- **Workflow**: `.github/workflows/sync-public.yml` - Runs on push to `main`
- **Command**: `just sync-public` - Test locally (dry-run by default)
- **Verification**: `just verify-sync-manifest` - Validates manifest

**Important:**

- Only files listed in `sync-public.toml` are published
- Files not in manifest are **deleted** from public repo during sync
- When adding new public content, add to `sync-public.toml`

## Common Tasks

### Adding a New ADR

1. Create a single `.md` file in `doc/decisions/{org}/{category}/` (e.g., `doc/decisions/dhcw/technical-decisions/my-decision.md`)
2. Use kebab-case for the filename matching the decision title
3. Copy content from template: `doc/design-authority/dhcw/architecture-decision-record-template.md`
4. Update `zensical.toml` navigation
5. If public: add to `sync-public.toml`
6. Add cross-references to related documents where relevant
7. Run `just qa` to validate

**Note**: Do NOT create a directory with `index.md` - use a single file instead (see `doc/decisions/dhcw/meta-decisions/simplify-architecture-decision-records-structure.md`)

### Adding a New Principle

1. Create markdown file in `doc/principles/{org}/` (e.g. `doc/principles/dhcw/`)
2. Follow existing principle structure
3. Update `zensical.toml` navigation
4. If public: add to `sync-public.toml`
5. Add cross-references to related documents where relevant
6. Run `just qa` to validate

### Converting Markdown to Word

For stakeholder review:

```bash
just word           # Converts templates to .docx format
```

Converts:

- `doc/design-authority/dhcw/architecture-decision-record-template.md`
- `doc/design-authority/dhcw/architecture-design-overview-template.md`

Uses styling from: `.github/workflows/markdown-to-word-styles.docx`

### Deploying to GitHub Pages

**Note**: Only runs from public repository after sync.

```bash
just deploy         # Manual deployment (requires permissions)
```

## Scripts

Python scripts in `scripts/` directory:

- **`check-links.py`** - Validates internal markdown links
- **`verify-sync-manifest.py`** - Validates sync manifest files exist
- **`sync-public.py`** - Syncs files to public repository

All scripts support `-h` flag for help.

## Troubleshooting

### Build Warnings

If `just build` shows warnings:

1. Check the warning message carefully
2. Most warnings indicate:
   - Missing files referenced in navigation
   - Broken internal links
   - Missing markdown extensions

### Lint Failures

If `just lint` fails:

1. Review the markdownlint errors
2. Check `.markdownlint-cli2.jsonc` for rules
3. Common issues:
   - Inconsistent list indentation (must use 4 spaces)
   - Missing blank lines
   - First heading in a file must be level 1 (`#`) and there must be only one level 1 heading
   - **Bold** text on its own line cannot be used in place of a real heading

### Link Check Failures

If `just check-links` fails:

1. The script reports the broken link and source file
2. Verify the target file exists at the expected path
3. Check for typos in relative paths
4. Ensure markdown file extensions are included

### Sync Manifest Failures

If `just verify-sync-manifest` fails:

1. Files listed in `sync-public.toml` don't exist
2. Update manifest to remove deleted files
3. Or restore the missing files

## Python and Node.js Environments

### Python Environment

- **Managed by**: uv (universal Python package manager)
- **Dependencies**: `pyproject.toml`
- **Lock file**: `uv.lock`
- **Sync command**: `just sync` or `uv sync`
- **Virtual environment**: `.venv/` (auto-managed by uv)

### Node.js Environment

- **Used for**: Markdown linting only
- **Dependencies**: `package.json`
- **Lock file**: `package-lock.json`
- **Install command**: `npm install` (if needed)

## Testing Your Changes

1. **Build the site**: `just build` (check for warnings)
2. **Run quality checks**: `just qa` (must pass)
3. **View locally**: `just run` (verify rendering)
4. **Check specific files**: Navigate to them in browser at <http://127.0.0.1:8000>

## Pull Request Checklist

Before creating or updating a PR:

- [ ] Run `just build` - No warnings
- [ ] Run `just qa` - All checks pass
- [ ] Run `just run` - Changes render correctly
- [ ] Updated `zensical.toml` if adding/removing pages
- [ ] Updated `sync-public.toml` if content should be public
- [ ] Followed ADR template if creating an ADR
- [ ] Markdown files follow 120 character line limit
- [ ] All internal links resolve correctly

## Additional Resources

- **Zensical Documentation**: <https://zensical.org/>
- **Architecture Site**: <https://gigcymru.github.io/architecture/>
- **Public Repository**: <https://github.com/GIGCymru/architecture>

## Development Environment Options

For human contributors, this repository supports multiple development environments:

1. **GitHub Codespaces** (Recommended) - Pre-configured cloud environment
2. **Local Development** - Traditional local setup
3. **Container-based** - Using Podman or Docker

See `README.md` for detailed setup instructions for each option.

## Notes for AI Agents

- This repository is **pre-configured** via `.github/workflows/copilot-setup-steps.yml`
- All dependencies are already installed when the agent starts
- **ALWAYS run `just qa`** before committing changes
- **ALWAYS run `just build`** to check for build issues
- Focus on minimal, surgical changes to existing files
- Respect the existing documentation structure and conventions
- When in doubt about ADR structure, refer to the template and naming conventions documents
- **If making changes that affect these instructions, `AGENTS.md`, or `README.md`** - update those files accordingly to keep documentation synchronized
