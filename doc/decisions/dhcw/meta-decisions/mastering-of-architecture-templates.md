# Mastering of Architecture Templates

!!! info

    **Status**: Accepted

    **Level**: 1

    **Updated**: 2025-10-20

## Summary

This decision addresses the need to establish a definitive source of truth for
the Architecture Decision Record (ADR) and Architecture Design Overview (ADO)
templates. The decision is to master these templates in Markdown within this
GitHub repository. Microsoft Word versions will be automatically generated from
the Markdown source to support various stakeholders. This approach preserves
the benefits of a "docs-as-code" methodology while lowering the barrier to
entry for individuals less familiar with Markdown and GitHub.

## Drivers

* **Accessibility for All Stakeholders:** A primary driver is to enable staff
  with limited or no GitHub/Markdown experience to engage with the ADR/ADO
  process. Providing Word-based templates lowers the barrier to entry.
* **Single Source of Truth:** To prevent versioning conflicts, content drift,
  and maintenance overhead, it is crucial to maintain a single, definitive
  master copy of each template.
* **Efficiency and Automation:** The process for maintaining both Markdown and
  Word versions must be efficient. Manual synchronization is error-prone and
  time-consuming.
* **Alignment with Existing Principles:** The decision should align with our
  existing preference for Markdown, as established in the ADR
  [Format Architecture Decision Records with Markdown](format-architecture-decision-records-with-markdown.md),
  which values simplicity and developer-friendliness.

## Options

### Option 1: Master in Markdown, Generate Word

The templates will be mastered as Markdown files within the GitHub repository. A
CI/CD pipeline (e.g., GitHub Actions) using a tool like Pandoc will
automatically generate Microsoft Word versions whenever the source Markdown
files are updated.

* **Source of Truth:** GitHub (Markdown)
* **Word Version:** Generated artifact

### Option 2: Master in Word, Manually Convert to Markdown

The templates will be mastered as Word documents, likely stored in SharePoint.
Markdown versions would be created and updated manually by copying content from
the Word document.

* **Source of Truth:** SharePoint (Word)
* **Markdown Version:** Manual copy

### Option 3: Dual-Manual Maintenance

Maintain both Markdown and Word versions of the templates manually. Both
versions would be considered "master" copies, and changes in one would need to
be replicated in the other by hand.

* **Source of Truth:** Both GitHub (Markdown) and SharePoint (Word)
* **Synchronization:** Manual

## Options Analysis

### Option 1 Assessment

**Pro:**

* **Single Source of Truth:** Establishes a definitive master version in a
  version-controlled environment.
* **Automation:** The generation of Word documents is automated, ensuring
  consistency and minimizing manual effort.
* **Alignment:** Reinforces the "docs-as-code" approach and aligns with the
  existing decision to use Markdown.
* **Collaboration:** Technical stakeholders can easily collaborate on the
  templates using standard Git workflows.

**Con:**

* **Formatting Limitations:** The automatically generated Word documents may not
  have the same level of rich formatting or stylistic flexibility as a manually
  crafted Word document.
* **Feature Limitation:** The automatically generated Word documents may not
  utilise dynamic content features of Word, such as generated table of contents
  or diagrams etc.

**Other:**

* Leverages existing, well-understood tooling like GitHub Actions.

### Option 2 Assessment

**Pro:**

* **Feature Rich Tooling:** Allows template editors to use the full feature set
  of Microsoft Word.
* **Accessibility:** Easier for non-technical staff to edit the master
  templates directly.

**Con:**

* **Manual Effort:** Manual conversion to Markdown is tedious and highly
  susceptible to human error.
* **Version Control:** Storing the master copy outside of Git makes tracking
  changes and managing versions more difficult.
* **Friction for Developers:** Creates an inconvenient workflow for technical
  staff who prefer plain text and Git.

### Option 3 Assessment

**Pro:**

* **Format Optimization:** Allows each version to be perfectly formatted using
  its native tools.

**Con:**

* **High Overhead:** Requires double the effort to maintain and is the most
  expensive option in terms of time.
* **Synchronization Issues:** It is virtually guaranteed that the two versions
  will become out of sync over time.
* **Confusion:** The lack of a single source of truth creates confusion for
  users.

## Recommendation

The decision is to adopt **Option 1: Master in Markdown, Generate Word**.

This option provides the best balance of all requirements. It establishes a
single source of truth in a version-controlled system, aligns with our
established architectural principles, and uses automation to provide accessible
Word versions for all stakeholders. While we accept the potential for minor
formatting limitations in the generated Word documents, the benefits of
consistency, low maintenance overhead, and a clear, automated workflow far
outweigh this drawback.

### Consequences

**Pro:**

* A clear process and ownership for template management is established.
* Administrative overhead is significantly reduced.
* The ADR/ADO process becomes more accessible to a wider range of
  stakeholders.

**Con:**

* We accept that the generated Word documents will be functionally effective
  but may not be as aesthetically polished as a manually created document.

**Other:**

* A GitHub Actions workflow for Pandoc conversion will be created and
  maintained as part of our CI/CD process.

### Confirmation

* **Verification:** The decision will be considered implemented once a GitHub
  Actions workflow is created that successfully converts the ADR and ADO
  Markdown templates into Word documents (`.docx`).
* **Adherence:** This automated workflow will be the sole approved method for
  producing the Word versions of the templates. Manual creation and uploading
  will be discouraged.
* **Metrics:** Success will be measured by the consistent availability of
  up-to-date Word templates that accurately reflect the latest version of their
  Markdown masters.

## More Information

This decision builds upon the principles set out in a previous decision:

* [Format Architecture Decision Records with Markdown](format-architecture-decision-records-with-markdown.md)
