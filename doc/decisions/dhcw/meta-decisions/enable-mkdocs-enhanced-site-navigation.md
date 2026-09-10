# Use Awesome-Nav for Site Navigation

!!! warning "Deprecated"
    This decision has been superseded by [Use Zensical for Publishing](use-zensical-for-publishing.md). Material for MkDocs was our previous documentation platform, but we have migrated to Zensical as the natural evolution created by the same team. This migration negated the need for `awesome-nav` as Zensical offers sufficient nav structure for our
    needs right now. The general Recommendations in this ADR remains in terms of approach to site navigation, just
    without the specific plugin being needed.

!!! info
    **Status**: deprecated

    **Level**: 1

    **Date**: Updated 2025-04-08

    **Deprecated**: 2025-11-14

    **Superseded by**: [Use Zensical for Publishing](use-zensical-for-publishing.md)

## Situation - Context and Problem Statement

The currently published docs don't have a good structure/navigation and we have a mix of approaches (folders, named files etc). We need to review this and decide an approach.

## Background - Decision Drivers

* Ideally minimise the need to manually maintain the navigation, accepting this may be unavoidable.
* We want a solution that provides good flexibility in structure/hierarchy/naming etc.
* We should have a logical structure for navigation that would make sense to consumers.
* It would be good to also publish architectural principles, so consider how these could fit in.
  
### Joel's learning from past experience

I have a very-strong preference for always using a topic folder. This is earned learning thanks to many clients.
It's the least-worst solution I've found in practice, for a bunch of reasons.

I have a moderately-strong preference for always using a file index.*, which makes the work highly compatible with web services.

GitHub doesn't do automatic rendering of the index.md file, even when there's no README.md file. My opinion is this is a problem with GitHub, and is easy enough to fix with a symlink, though the symlink sometimes (50%?) have subpar UI effects in other pipeline tooling.

I do many projects where the index file format isn't markdown. The most common for web documentation is index.html, for web APIs is index.json, for web data is index.tsv, for databases is index.sql, etc. In my experience this pattern scales really well.

I have a moderate preference for all folders using kebab-lower-case-plural by default, because this works especially well for web slugs, autocomplete, AI ingestion, etc.

GitHub is notoriously bad about sorting by case-sensitive first, which IMHO is a UI/UX bug.

I do use many exceptions though, if a project/platform/language uses conventions, such as Apple XCode using "FooBars" word case no spaces, or Rust Axum using "foo_bars" snake case, or JavaScript Express using singular camel case "fooBar".

## Assessment - Considered Options

In order to keep the index.md/README.md in a folder structure approach and sticking with MkDocs, after some research it looks like we will need to manually set/maintain the navigation, this can be done natively in MkDocs config but it has some limitations (e.g. won't show anything that isn't manually added to the nav explicitly); therefore we should consider MkDocs plugins - assessed below:

### mkdocs-literate-nav

[mkdocs-literate-nav](https://github.com/oprypin/mkdocs-literate-nav) - lets you create a ``SUMMARY.md`` file containing the name in the ``doc/`` folder itself e.g.

```markdown
* [Alpha](alpha.md)
* [Beta](beta.md)
* [Delta](delta.md)
    * [Bar](delta/bar.md)
    * [Foo](delta/foo.md)
```

You can also nest ``SUMMARY.md`` files, so each sub-folder can maintain its own nav structure if desired. Also allows for parts of the nav to be manually set and other parts to be auto-populated based on folder/structure etc. and supports wildcards.

Because the Nav is in Markdown it would also render in GitHub.

### mkdocs-awesome-nav

[mkdocs-awesome-nav](https://lukasgeiter.github.io/mkdocs-awesome-nav/) - Similar to literal nav but nav is configured via YAML files.

```yaml
sort:
  sections: mixed

nav:
  - About:
    - Getting Started: index.md
    - philosophy.md
    - migration-v3.md
  - "*"
```

Looks to offer more configuration/flexibility, such as automatic sorting of pages and also ['flattening'](https://lukasgeiter.github.io/mkdocs-awesome-nav/features/flattening/) of structure - which would help with the one folder per document preference.

## Recommendation - Decision Outcome

1. Adopt the mkdocs-awesome-nav plugin as it does everything we need, including flattening navigation
2. Enable MkDocs headers and footers in the published site to make navigation easier
3. Set top level headings such as Home, Decision, Principles, Values
4. Flatten the nav to remove empty nested items as needed
5. Determine a logical structure and evolve over time as need records are added
