# GIG Cymru NHS Wales - Architecture

[![zensical](https://github.com/GIGCymru/architecture/actions/workflows/publish.yml/badge.svg)](https://github.com/GIGCymru/architecture/actions/workflows/publish.yml)

**[View the Published Site](https://gigcymru.github.io/architecture/)**.

> [!IMPORTANT]  
> There are two GitHub repositories:
> * an **internal** repository: [https://github.com/GIGCymru/architecture-internal](https://github.com/GIGCymru/architecture-internal)
> * and a **public**, read-only repository: [https://github.com/GIGCymru/architecture](https://github.com/GIGCymru/architecture)
>
> The **public** repository is synchronised automatically when changes are pushed
> to the `main` branch of the **internal** repository. This setup allows us to
> review and vet content before it is published in the public domain. The
> process requires files be explicitly selected to be made public to avoid
> unintentional publishing. See [Public Synchronisation](#public-synchronisation) for details
> of how this works and how to include/exclude specific files.
>
> If you want to make a contribution, ensure you are working with the
> **internal** repository.
>
> Note: This 'site' is published to GitHub pages from the **public** 
> repository to: [https://gigcymru.github.io/architecture/](https://gigcymru.github.io/architecture/)

## Introduction

This repository hosts architecture related content and decisions, such as
architecture principles, architecture decision records (ADRs) and governance
information.

Our site is built using [Zensical](https://zensical.org/), a modern static site
generator from the team behind Material for MkDocs.

## Getting Started

There are several ways to set up your development environment:

### 1. GitHub Codespaces (Recommended)

The fastest way to start contributing:

[![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://codespaces.new/GIGCymru/architecture-internal?quickstart=1)

This provides:

* A pre-configured VS Code environment (with useful extensions installed)
* All required dependencies installed
* Automatic port forwarding for preview
* Git integration

Once you have successfully launched Codespaces, dependencies will be automatically
installed. You can start the development server from the VS Code Terminal:

```bash
    just run
```

You will be prompted to **Open in Browser** to view the locally running site.

To see all available commands run:

```bash
    just --list
```

See the [Quickstart Guide](http://docs.github.com/en/codespaces/quickstart) for
more information on using Codespaces.

Note: It can take a few minutes to fully launch Codespaces the first time, but
is faster on subsequent launches as the environment is then cached.

### 2. Local Development

**Prerequisites:**

* Python 3.13 or higher
* [uv](https://github.com/astral-sh/uv) for package/env management
* [npm](https://github.com/npm/cli) for markdown linting
* Git

**Setup Steps:**

Clone the repository:

```bash
    git clone git@github.com:GIGCymru/architecture.git
    cd architecture
```

Install uv (if not already installed):

```bash
    curl -LsSf https://astral.sh/uv/install.sh | sh
```

Set up environment and dependencies:

```bash
    uv sync
```

Start the development server:

```bash
    uv run zensical serve
```

View the documentation at: ``http://127.0.0.1:8000/``

### 3. Container-based Development

If you prefer using containers:

**Prerequisites:**

* [Podman](https://podman.io/) or [Docker](https://www.docker.com/)

**Setup Steps:**

Build the container:

```bash
    podman build --tag zensical .
```

Run the development server:

```bash
    podman run -p 8000:8000 zensical
```

View the documentation at: ``http://127.0.0.1:8000/``

### 4. Just-based Workflow

For those familiar with Just (a modern command runner):

**Prerequisites:**

* [Just](https://github.com/casey/just) - Install with: `curl --proto '=https' --tlsv1.2 -sSf https://just.systems/install.sh | bash -s -- --to ~/.local/bin`

**Setup Steps:**

```bash
    # See available commands
    just --list

    # Full build and serve
    just
```

View the documentation at: ``http://127.0.0.1:8000/``

## Quality Assurance

Various QA checks are run automatically when a Pull Request is created via the
[.github/workflows/pr-quality.yml](.github/workflows/pr-quality.yml) and will
report an error if there are any failures (preventing merging of the PR).

All checks can and should also be run locally using the `just qa` command.

### Markdown Linting

This project uses `markdownlint-cli2` to lint the markdown files in the [doc/](doc/) directory.

To run the linter, you will first need to install it using `npm`:

```bash
npm install
```

Once it is installed, you can run the linter by running the following command:

```bash
just lint
```

This will check all the markdown files in the `doc/` directory and report any errors.

### Spell Checking

This project uses `cspell` to spell check the markdown files in the [doc/](doc/) directory.

To run the spell checker, you will first need to install it using `npm`:

```bash
npm install
```

Once it is installed, you can run the spell checker by running the following command:

```bash
just spell
```

This will check all the markdown files in the `doc/` directory and report any spelling errors.

The spell checker is configured using the `cspell.json` file in the root of the repository. This file contains
project-specific words and ignore patterns that are allowed in the documentation.

**GitHub Actions Integration:** When running in pull requests, the spell checker uses the official
`streetsidesoftware/cspell-action` GitHub Action to display spelling errors as inline annotations in the Files
Changed view, making it easier to identify and fix spelling issues.

### Internal Link Checker

We also provide a custom script to verify that all internal markdown links
resolve correctly and that linked files are included in the public sync
manifest (links to excluded files fail the check). This script automatically
ignores links within code blocks to avoid false positives.

To check all internal links (defaults to checking the [doc/](doc/) directory):

```bash
just check-links
```

You can pass a specific path to the script to check files under that path e.g.

```bash
just check-links doc/principles/
```

### Sync Manifest Verification

To ensure the integrity of the public repository synchronization, we provide a
script that verifies all files listed in `sync-public.toml` actually exist in
the repository. This prevents sync failures due to missing or renamed files.

To verify the sync manifest:

```bash
just verify-sync-manifest
```

This check runs automatically as part of the PR quality workflow and as part of
`just qa`.

### Sync Excluded Navigation Check

We also verify that any files listed in the Zensical navigation are included in
the public sync manifest. This prevents navigation entries from pointing to
content that is excluded from the public repository.

To check for excluded navigation entries:

```bash
just check-sync-excluded-nav
```

This check runs automatically as part of the PR quality workflow and as part of
`just qa`.

### Listing Sync Excluded Files

For informational purposes, you can view which git-tracked files are excluded
from the public sync manifest. This command is useful for understanding what
content remains internal-only.

To list excluded files:

```bash
just list-sync-excluded
```

This command displays a summary showing:

- Total count of tracked files
- Total count of files in the sync manifest
- Total count of excluded files
- A list of all excluded file paths

**Note:** This is an informational-only command that does not fail the build. It
runs as part of `just qa` to provide visibility into sync exclusions, but it
does not run in the PR workflow and does not block merging. You are not required
to act on its output unless you specifically need to add or remove files from
the public sync manifest.

The output can be useful when:

- Verifying that sensitive or internal-only files are correctly excluded
- Reviewing what content is available publicly vs. internally
- Deciding whether to add new files to the sync manifest

## Converting Markdown to Word

This repository includes a GitHub workflow to automatically convert specific
Markdown files into Microsoft Word documents. This is useful for sharing
formatted documents with stakeholders who may prefer Word format.

The conversion is handled by [Pandoc](https://pandoc.org/), a universal
document converter.

### Automated Workflow

The GitHub Action workflow is defined in [.github/workflows/markdown-to-word.yml](.github/workflows/markdown-to-word.yml).
It is triggered on pushes to the `main` branch that include changes to the
following files:

* [doc/design-authority/dhcw/architecture-decision-record-template.md](doc/design-authority/dhcw/architecture-decision-record-template.md)
* [doc/design-authority/dhcw/architecture-design-overview-template.md](doc/design-authority/dhcw/architecture-design-overview-template.md)

When triggered, the workflow creates a new release with the converted `.docx` files.

### Manual Conversion

You can also run the conversion manually. This is helpful for testing changes
to the templates or the style reference file before pushing to the repository.

**Prerequisites:**

* [Pandoc](https://pandoc.org/installing.html) installed on your local machine.

**Command:**

To convert the documents, run the following command from the root of the repository:

```bash
# Convert all markdown files to word documents
just word
```

### Styling

The appearance of the generated Word documents is controlled by a reference
document: [.github/workflows/markdown-to-word-styles.docx](.github/workflows/markdown-to-word-styles.docx).
To change the styling (e.g., fonts, headings, spacing), you can edit the styles
within this `.docx` file in Microsoft Word, save your changes, and commit the
updated file. Pandoc will then use the styles from this reference document
during conversion.

## Public Synchronisation

See [Internal and Public Repository Split](doc/decisions/dhcw/meta-decisions/internal-and-public-repo-split.md)
for the decision record governing this workflow.

This setup ensures that we can draft and review content internally before it is
published to the public website.

The [sync-public.toml](sync-public.toml) manifest lists the files that should
be synchronised to the **public** repository. There is a [scripts/sync-public.py](scripts/sync-public.py)
script that synchronises the files specified in the manifest against a local
clone of the **public** repository. 

This script is run automatically on pushes to the `main` branch of the
**internal** repository via the [.github/workflows/sync-public.yml](.github/workflows/sync-public.yml)
workflow (note you will find this file in the **public** repository in
`.github-internal/workflows/sync-public.yml` to prevent it running on that repo).

The workflow uses a GitHub App for authentication to allow it to push to the
restricted `main` branch of the public repository. This requires the following
configuration in the **internal** repository:

* `SYNC_APP_ID` (Variable): The **numeric** App ID of the GitHub App (e.g., `123456`).
  Find this in the GitHub App settings page or in the settings URL path. **Do not** use the app name.
* `SYNC_APP_PRIVATE_KEY` (Secret): The private key of the GitHub App.

You can run this script manually using `just`:

```bash
just sync-public
```

This will run as a `dry-run` if you want to apply the changes you must pass the
`--apply` argument.

> [!TIP]
> Example of how to run this script locally (e.g. in Codespaces) from the terminal:
>
> ```bash
>
>   # clone public repo to a folder outside the current repo
>   cd ..
>   git clone https://github.com/GIGCymru/architecture.git
>
>   # return to the internal repo to run the script
>   cd architecture-internal
>   just sync-public ../architecture
>
>   # if this dry-run looks good, apply the changes
>   just sync-public --apply ../architecture
> ```

Each entry in [sync-public.toml](sync-public.toml) can be a string path (the
file will be copied to the same location in the public repository) or a table
to map to a different location, for example:

```toml
files = [
  "doc/index.md", 
  { source = "doc/overrides/partials/integrations/analytics/simple.html", dest = "overrides/analytics.html" },
]
```

Note:

* Files that exits in the public repository but aren't in the
  [sync-public.toml](sync-public.toml) will be deleted by this script.

* [.github/dependabot.yml](.github/dependabot.yml) is excluded as dependabot
  runs on the **internal** repository only (dependencies updates are then
  synchronised automatically to the public repo).

* The GitHub Pages workflow at [.github-public/workflows/publish.yml](.github-public/workflows/publish.yml)
  is copied to `.github/workflows/publish.yml` so it only runs on the
  **public** repository.

## Contributing

1. Ensure you are working with the **internal** repository
2. Choose your preferred development environment from above
3. Create a new branch for your changes
4. Make your changes
5. Test your changes locally
6. Submit a Pull Request

See also [CONTRIBUTING.md](CONTRIBUTING.md) and [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md).

## License

This repository is licensed under the [MIT License](LICENSE)
