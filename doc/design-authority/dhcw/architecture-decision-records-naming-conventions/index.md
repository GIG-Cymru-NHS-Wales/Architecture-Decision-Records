# Architecture Decision Records Naming Convention

!!! note "Pending Approval"
    Awaiting approval by DHCW Technical Design Authority

**Status**: proposed  
**Date**: 2025-03-25  
**Governance**: Drafted for DHCW Technical Design Authority (TDA) for approval

## Situation - Context and Problem Statement

* We want to record architecture related decisions for NHS Wales organisations, made via agreed governance mechanisms.
* We need to agree a **naming convention** for the records i.e how to name records and refer to them.
* We should also agree a **folder & filename convention** aligned with the naming convention.

## Background - Decision Drivers

We want:

* a consistent naming convention for our decisions.
* names to be human readable and easy to understand.
* to be able to cross-reference Architecture Decision Records easily.
* the naming to support multiple Architecture Decision Records being developed in parallel (i.e. avoid naming clashes).

## Assessment - Considered Options

For naming itself:

* Just sequential numbering e.g. ADR 0001, ADR 0002, ...
* Sequential numbering and titles e.g. ADR 0001 - Title, ADR 0002 - Title, ...
* Just titles e.g. "Title of a Record"
* Formless – No naming convention - author's choice.

For filenames:

* The title of the Architecture Decision Record as above as-is e.g. ``Title Goes Here.md``
* Use of lowercase 'kebab' style for filenames e.g. ``title-goes-here.md``
* Use of lowercase 'snake' style for filenames e.g. ``title_goes_here.md``

On acronyms:

* Use 'ADR' as an acronym for Architecture Decision Record.
* Avoid acronyms, e.g. always spell out "Architecture Decision Record" in full.

## Recommendation - Decision Outcome

### Naming Conventions

Adopt an Architecture Decision Record **naming convention** of:

* Just titles, in Title Case
* Author to ensure the title makes it clear what the decision relates to.
* Author to ensure titles are human readable and unique.
* Avoid the use of acronyms
* Examples:
  * 'Use Architecture Decision Records and Structure'
  * 'Architecture Decision Records Naming Conventions'
  * 'Format Architecture Decision Records with Markdown'

Whilst numbering Architecture Decision Records makes them easy to cross-reference, it introduces an administrative/process overhead to ensure numbers are unique and sequential and adds complexity in the ordering of records, especially when multiple records are in development in parallel (which gets published first, who gets the next record number etc.)

Avoiding acronyms and using human readable names makes them easier for users to understand, refer to and talk about.

**Note:** We are referring to '**_Architecture_**' decision records, not '_Architectural_' or other similar words.

**Note:** Readability is important, it may be better to refer to Architecture Decision Records as _decisions_ and _records_ in documents rather than always writing out the full _Architecture Decision Records_ every time e.g.

* "This **_record_** builds on the previous **_decision_**" (good - emphasis only added here for clarity).
* "This _Architecture Decision Record_ builds on the previous _Architecture Decision Record_" (worse/avoid).

### Folder and Filenames

Given the above, apply the following convention to the storage and naming of
records, this convention makes publishing easier even though it adds a little
complexity:

Each decision should have its own **folder**, whose name should match the
**Title** of the record, with whitespace removed and adopting a kebab style
e.g.

* ``./architecture-decision-records-naming-conventions/``
* ``./use-architecture-decision-records-and-structure/``
* ``./format-architecture-decision-records-with-markdown/``

Within each folder create an `index.md` file which contains the decision
contents. Create a symbolic link from `README.md` to `index.md` - this ensures
that GitHub renders the documents when navigating the repository e.g.

* ``./architecture-decision-records-naming-conventions/index.md``
* ``./architecture-decision-records-naming-conventions/README.md -> index.md``

Both ``index.md`` and ``README.md`` should be added and committed to Git.

???+ Tip "Creating a symbolic link (Windows/Mac/Linux)"

    === "Windows"

        You can think of a symbolic link as a shortcut that points to another
        file.

        Note PowerShell doesn't seem to create relative symbolic links so you
        must instead launch Command Prompt with Admin privileges, navigate to
        the folder containing the index.md and run:

        ``mklink README.md index.md``

        Running ``dir`` afterwards should show output similar to this:

        ```
            > dir
             ...
            16/05/2025  13:04    <DIR>          .
            16/05/2025  13:01    <DIR>          ..
            16/05/2025  13:01             5,660 index.md
            16/05/2025  13:04    <SYMLINK>      README.md [index.md]
        ```

    === "MacOS/Linux"

        Navigate to the folder containing the index.md and run:

        ``ln -s index.md README.md``

### Cross Referencing

When cross-referencing decisions, use the full title of the decision and add
a relative link to the record ``index.md`` itself e.g.

* See [Architecture Decision Records Naming Conventions](../architecture-decision-records-naming-conventions/index.md)

### Branches

Git branch names should utilise the same convention as the main folder name of
the decision itself e.g.

* ``git checkout -b architecture-decision-records-naming-conventions``

### Confirmation

This decision will be enforced by reviewers of newly submitted records, who should refer to this decision and confirm the naming convention and decision herein is being adhered to.

## More Information

See [Use Architecture Decision Records and Structure](../use-architecture-decision-records-and-structure/index.md) for the structure of records.
