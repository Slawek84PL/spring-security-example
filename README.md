# spring-security-example
W bazie (liście) są dwa konta user:user i admin:admin
można zalogować się na oba.

"/" - widzą wszysyc

"/user" - widzi user i admin oraz każdy nowo dodany użytkownik

"/admin" - widzi admin

"/register/{username}/{pass} - tylko admin może zarejestrować w ten sposób nowego użuytkownika.
nowy użytkownik dostaje role USER i może wejść tylko do "/" i "/user".
rejestruje GetMaping, ale to żeby nie trzeba wbijać do postmana.

"/logout" - możesz wylogować się i zalogować na nowo dodane konto.

Po zamknięciu aplikacji nowo dodane konta są kasowane
