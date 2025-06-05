# Domain Name System Security Extensions (DNSSEC)

!!! info

    **Status**: RFC WIP

    **Level**: { 1 - 4 }

    **Updated**: {2025-06-03}

## Summary

We need to secure domain name resolution in a way that prevents attackers from
tampering with DNS responses or redirecting users to malicious servers.

## Drivers

Context: DNS (Domain Name System) is a foundational internet service that
resolves domain names into IP addresses. However, traditional DNS is vulnerable
to spoofing and cache poisoning attacks because it lacks built-in data integrity
or authentication. This can lead to users being directed to malicious sites or
intercepted via man-in-the-middle attacks. DNSSEC (Domain Name System Security
Extensions) adds cryptographic signatures to existing DNS records to ensure
authenticity and integrity, mitigating many of these threats.

* {e.g. We are developing a new feature/capability that needs...}
* {e.g. We need to improve performance, accessibility, remove debt...}
* {e.g. Feedback from users suggests...}
* {e.g. The current approach imposes these limitations...}

## Options

1. **DNSSEC**

2. **DNS-over-HTTPS (DoH) or DNS-over-TLS (DoT)**

   * Provides privacy/encryption but not data integrity/authentication like DNSSEC. Both can be complementary, not replacements.

3. **Split-horizon DNS with internal validation**

   * Useful for internal networks, but doesn’t protect public-facing domains or external users.

4. **Do nothing**

   * Simpler operationally, but leaves DNS vulnerable to attacks.

## Options Analysis

{This is where you critically evaluate each option presented in the *Options*
section. For each option, provide a balanced view of its advantages,
disadvantages, and any other relevant considerations or trade-offs. Be specific
and, where possible, relate your points back to the *Drivers*.

Consider aspects like:

* Cost (development, operational, licensing)
* Complexity (implementation, maintenance, learning curve)
* Risks (technical, operational, security)
* Alignment with architectural principles or existing standards
* Impact on performance, scalability, usability, maintainability,
    security etc.

Include as may Pro/Con/Other statements as required.
}

## Recommendation

**Decision:**

We will implement **DNSSEC** for all publicly resolvable domain names we manage.

* **DNS zones** will be signed using DNSSEC-compliant algorithms (initially RSASHA256).
* **Zone signing keys (ZSK)** and **key signing keys (KSK)** will be generated and rotated according to a secure, auditable key management policy.
* **DS (Delegation Signer) records** will be submitted to registrars for inclusion in the parent zone to establish the chain of trust.
* DNSSEC validation will be enabled on internal recursive resolvers to validate upstream responses.

**Consequences:**

*Positive:*

* Improves trust and security of DNS responses.
* Protects against DNS cache poisoning and spoofing attacks.
* Supports compliance with regulatory requirements and best practices (e.g., NIST, FedRAMP, GDPR).

*Negative:*

* Adds operational complexity in key management, signing, and rollover procedures.
* Increases DNS response size, potentially leading to issues with some misconfigured firewalls or middleboxes.
* Misconfiguration (e.g., expired or mismatched keys) may lead to domain resolution failures.

**Implementation Plan:**

1. Inventory all zones and registrars.
2. Enable DNSSEC on staging/testing environment.
3. Automate key generation and signing using tools like BIND, OpenDNSSEC, or Knot.
4. Submit DS records and validate delegation.
5. Monitor DNSSEC with tools like Zonemaster and Nagios plugins.
6. Educate operations team on DNSSEC key rollover and failure handling.
