# Use Material for MkDocs for Publishing

!!! note "Pending Approval"
    Awaiting approval by DHCW Technical Design Authority

**Status**: proposed  
**Date**: 31/03/2025  
**Governance**: Drafted for DHCW Technical Design Authority (TDA) for approval

## Situation - Context and Problem Statement

We are capturing architecture decisions as plaintext Markdown documents and
storing these in a GitHub repository. This is quite a 'technical' way of working
that requires understanding of Git, Markdown and the GitHub.com website and
workflow. This represents a barrier for people engaging with our content.

## Background - Decision Drivers

We want:

* to use our existing Markdown files, not create separate documents
* the content to be open and public (no login, paywall, registration etc.)
* the content to be kept up-to-date automatically
* a good user experience and visual design
* alignment with NHS Wales branding
* the ability for user to search our content
* the ability for users to navigate our content in a logical and structured way
* a widely supported approach/technology
* a free and open source solution
* low or no cost
* something easy to configure/manage and work with
* flexibility to change in the future should we choose

## Assessment - Considered Options

* [GitHub Pages](https://pages.github.com/) with [Jekyll](https://jekyllrb.com/)
* [Docusaurus](https://docusaurus.io/docs)
* [Readthedocs](https://about.readthedocs.com/)
* [MkDocs](https://www.mkdocs.org/)
* [Material for MkDocs](https://squidfunk.github.io/mkdocs-material/)
* A review of these [alternative tools](https://docusaurus.io/docs)

## Recommendation - Decision Outcome

Use [Material for MkDocs](https://squidfunk.github.io/mkdocs-material/) hosted
on  [GitHub Pages](https://pages.github.com/).

Rationale:

* MkDocs allows us to build static HTML files from Markdown files, these can be
published using GitHub Pages, at no cost.
* MkDocs is FOSS; mature, well supported and actively maintained.
* It is simple to setup and run locally.
* It is based on Python, which is destined to be one of our preferred languages.
* It is straightforward to automate publishing using GitHub Actions, meaning the
site is always up-to-date with the latest changes.
* The 'Material' theme provides a good user experience that is visually pleasing
* Plugins and Markdown extensions provide us flexibility to enhance the site in
future.
* The default site/layout/organisation fits our needs/audience well.
* It is is commitment, we could change to another of the solutions with minimal
effort in the future.

Other options ruled out:

* Docusaurus - preference was for a static HTML site rather than a Single Page
App/Javascript heavy approach, keeping things simple.
* readthedocs - Was a strong contender, and it does have a free plan, but this
has advertising embedded and an on-ramp to paid plans which we prefer to avoid
* Jekyll/GitHub Pages - The default site/layout/organisation wasn't as
favourable as Material for MkDocs.
