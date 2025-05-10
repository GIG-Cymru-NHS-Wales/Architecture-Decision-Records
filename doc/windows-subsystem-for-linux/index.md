# Windows Subsystem for Linux (WSL) as a default on software engineering laptops

!!! note
    Work in Progress

Windows Subsystem for Linux is a feature of Microsoft Windows that allows the
use of a GNU/Linux environment from within Windows, foregoing the overhead of a
virtual machine and being an alternative to dual booting.

**Status**: first sketch, work in progress, request for collaboration

**Date**: Updated 2025-04-17

**Governance**: To Be Discovered; potentially a combo of this repo partipants, DHCW CISO, NHS Wales UCB peers, etc.

## Drivers

Software engineers in our organization primarily use Windows laptops. However,
many development tools and workflows are optimized for Unix-like environments.

Currently, our software engineers do one or more of these:

* Work around missing Linux features using Windows-native tools

* Set up dual boot environments, which makes it harder to work in the first environment

* Install a virtual machine (e.g., VirtualBox or VMware)

* Use a bring-your-own-device approach, such as use a different laptop that
  organization doesn't control

* Spend time to learn how to install Unix and/or WSL e.g. days of delay due to
  requesting an elevated account, then doing ad hoc troubleshooting for WSL.

These approaches can increase complexity, slow down onboarding, and create inconsistencies in development environments.

Benefits:

* **Faster onboarding**: New hires get a Unix-like environment out of the box, reducing setup time.

* **Improved productivity**: Engineers can use familiar Linux commands and tooling without additional configuration.

* **Better tooling support**: Tools like Podman, Docker, Git, SSH, Python, and Node.js are more stable and predictable on Linux.

* **Industry best practice**: Many engineering organizations use WSL to standardize Linux development on Windows.

* **Reduced overhead**: WSL is more lightweight and simpler to maintain than full VMs.

## Options

Install and enable **Windows Subsystem for Linux (WSL)** by default on all software engineering laptops.

This includes:

* Installing the latest stable version of WSL (WSL 2)

* Providing a standard Linux distribution (e.g., Ubuntu) configured with essential tools

* Including WSL installation and configuration in onboarding automation/scripts

Or potential other options that are more extreme:

* Could we pre-install a virtual machine?

* Could we add cloud-based virtual environments, such as GitHub Codespaces?

* Could we provide software engineers with a second laptop, such as a Framework Linux laptop?

* Explicitly decide to ignore WSL in favor of non-Linux solutions.

### Considerations

* Requires some initial setup and education for those unfamiliar with WSL.

* Some tools may behave differently between native Windows and WSL environments, requiring documentation and awareness.

* Security and patching responsibilities for WSL instances must be included in IT operations processes.

## Decision

Ask IT for opinions.

Try a pilot with a couple of software engineers: Joel, Chris, possibly others.
