# Password hashing fucntions

!!! info

    **Status**: Proposed
    
    **Level**: ?

    **Updated**: 2025-06-10

## Summary

We have some applications that need to store passwords in a database.
We need to store these securely by using a password hashing function.
We need to choose among password hashing functions.

## Drivers

Priority order:

1. High security, meaning high resistance to attacks using extensive RAM, CPU,
   GPU, and AI.

2. High ecosystem availability, meaning functions that are available as
   libraries with implementations in popular programming languages.

3. Good acceptability meaning alignment with technology industry practices,
   which we known is somewhat-ahead-of government industry practices.

4. Implementation with single instruction, multiple data (SIMD) for efficiency
   during creating.

5. Compliance with standards as needed, such as if a government project mandates
   compliance with FIPS-140.

## Options

We evaluate on three options:

* Argon2

* scrypt

* PBKDF2

We reject these options as insufficient:

* SHA and any other fast hashing function, because password hashing functions must not be fast.

* AES and any other reversible encryption function, because password hashing functions must not be reversible.

* bcrypt, which is superseded by scrypt.

### Argon2

Demo: <https://github.com/joelparkerhenderson/demo-rust-argon2>

On Joel's MacBook, Argon2 0.5.3 has minor documentation gaps e.g. the docs don't show how to get the operating system random number generator.

### scrypt

Demo: <https://github.com/joelparkerhenderson/demo-rust-scrypt>

On Joel's MacBook, scrypt is much slower than the others to encrypt and also to verify.

### PBKDF2

Demo: <https://github.com/joelparkerhenderson/demo-rust-pbkdf2>

On Joel's MacBook, PBKDF 0.12.2 has minor documentation quirks e.g. the docs start by showing a lower-level example that uses static salt and a key buffer byte array, rather than a higher-level example that uses secure random salt and a password hash structure.

## Options Analysis

OWAPS has created a summary and recommendations here: <https://cheatsheetseries.owasp.org/cheatsheets/Password_Storage_Cheat_Sheet.html>

OWAPS writes…

To sum up our recommendations:

* Use Argon2id with a minimum configuration of 19 MiB of memory, an iteration count of 2, and 1 degree of parallelism.

* If Argon2id is not available, use scrypt with a minimum CPU/memory cost parameter of (2^17), a minimum block size of 8 (1024 bytes), and a parallelization parameter of 1.

* For legacy systems using bcrypt, use a work factor of 10 or more and with a password limit of 72 bytes.

* If FIPS-140 compliance is required, use PBKDF2 with a work factor of 600,000 or more and set with an internal hash function of HMAC-SHA-256.

* Consider using a pepper to provide additional defense in depth (though alone, it provides no additional secure characteristics).

## Recommendation

We use the OWASP recommendations if/until someone comes up with something better.

### Consequences

If we have passwords stored using less-secure password hashing functions, then
we should plan to migrate these.
