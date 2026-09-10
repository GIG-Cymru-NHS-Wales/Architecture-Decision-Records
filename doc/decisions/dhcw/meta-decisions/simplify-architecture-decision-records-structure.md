# Simplify Architecture Decision Records Structure

!!! info

    **Status**: Approved

    **Level**: 3

    **Updated**: 12-01-2026

    **Supersedes**: [Architecture Decision Records Naming Convention](architecture-decision-records-naming-conventions.md)

## Summary

This decision record establishes a simplified standard for naming and storing
Architecture Decision Records (ADRs), superseding the previous convention
defined in [Architecture Decision Records Naming Convention](architecture-decision-records-naming-conventions.md).
We are moving from a complex structure of individual folders with `index.md`
files and `README.md` symbolic links to a streamlined approach using single
Markdown files. This change directly addresses staff feedback regarding the
previous approach's complexity and resolves persistent technical issues with
creating and maintaining symbolic links on Windows systems.

## Situation

The previous convention required each ADR to be housed in its own folder with an
`index.md` file and a `README.md` symbolic link. While intended to optimise
GitHub rendering and web compatibility, this structure proved overly complex
for many contributors. Staff found the nested hierarchy confusing, and the
requirement to create and maintain symbolic links was a significant barrier,
particularly for those using Windows where command-line symlink creation is
often restricted or non-intuitive.

## Drivers

* **Reduced Complexity**: Staff found the previous folder-per-ADR approach confusing and difficult to navigate.
* **Platform Compatibility**: Creating and maintaining `README.md` -> `index.md` symbolic links is problematic on Windows, leading to friction in the contribution process.
* **Ease of Maintenance**: Single files are easier to move, rename, and manage than folder bundles.
* **Consistency**: We still want to record architecture-related decisions for NHS Wales organisations using a consistent naming convention.
* **Human Readability**: Records should be easy to understand and refer to without administrative overhead like sequential numbering.
* **Repository Scope**: As the repository now encompasses architecture principles, design authority, and other documentation, branch names need to clearly distinguish decision-related changes from other types of work.

## Options

Given the specific feedback and technical constraints identified, only one
option was considered to move the documentation forward:

### Single Markdown File Structure

Move away from the "page-as-directory" structure and adopt a flat, single-file
approach for each decision record. This entails:

* Replacing individual folders with single `.md` files.
* Removing the requirement for `index.md` files and `README.md` symbolic links.
* Utilising the existing kebab-case naming convention for filenames.

This option was pursued as the most effective way to eliminate confusion and
bypass the technical limitations of platform-specific symbolic link creation.

## Recommendation

This decision maintains the core principles of the previous naming convention
while simplifying the underlying storage mechanism. We will continue to use
descriptive titles and kebab-case filenames but will now utilise a single-file
structure for each record.

### Naming Conventions

The established **naming convention** remains unchanged:

* Just titles, in Title Case
* Author to ensure the title makes it clear what the decision relates to.
* Author to ensure titles are human readable and unique.
* Avoid the use of acronyms

Examples:

* 'Use Architecture Decision Records and Structure'
* 'Architecture Decision Records Naming Conventions'
* 'Format Architecture Decision Records with Markdown'

Whilst numbering Architecture Decision Records makes them easy to
cross-reference, it introduces an administrative/process overhead to ensure
numbers are unique and sequential and adds complexity in the ordering of
records, especially when multiple records are in development in parallel
(which gets published first, who gets the next record number etc.)

Avoiding acronyms and using human readable names makes them easier for users to
understand, refer to and talk about.

**Note:** We are referring to '**_Architecture_**' decision records, not
'_Architectural_' or other similar words.

**Note:** Readability is important, it may be better to refer to Architecture
Decision Records as _decisions_ and _records_ in documents rather than always
writing out the full _Architecture Decision Records_ every time e.g.

* "This **_record_** builds on the previous **_decision_**" (good - emphasis only added here for clarity).
* "This _Architecture Decision Record_ builds on the previous _Architecture Decision Record_" (worse/avoid).

### Folder and Filenames

Updated storage convention:

Each decision should be a single **Markdown file** located in the appropriate
category folder. The filename should match the **Title** of the record, with
whitespace removed and adopting a kebab style e.g.

* `simplify-architecture-decision-records-structure.md`
* `use-architecture-decision-records-and-structure.md`
* `format-architecture-decision-records-with-markdown.md`

Do not create subfolders for individual records unless they require multiple
supporting assets (like images).

### Cross Referencing

The convention for cross-referencing remains the same, updated for the new
file structure:

Use the full title of the decision and add a relative link to the record `.md`
file itself e.g.

* See [Simplify Architecture Decision Records Structure](simplify-architecture-decision-records-structure.md)

### Branches

Git branch names should utilise the same convention as the filename of the
decision itself, prefixed with `adr/` to categorise the work:

* `git checkout -b adr/simplify-architecture-decision-records-structure`

### Confirmation

This decision will be enforced by reviewers of newly submitted records, who
should refer to this decision and confirm the naming convention and decision
herein is being adhered to.

## More Information

See [Use Architecture Decision Records and Structure](use-architecture-decision-records-and-structure.md)
for the structure of records.
