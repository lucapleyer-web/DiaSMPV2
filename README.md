# Incomplete Golden Apples (Paper 26.3)

Paper/Bukkit-Port des Bedrock-Addons **„Incomplete Golden Apples"** – 1:1 übernommen, nur **ohne** das Rezept für den verzauberten goldenen Apfel.

## Rezepte (formlos, auch im 2x2-Raster bis 3/8)

| Ergebnis | Zutaten |
|---|---|
| 1/8 Golden Apple | 1 Apfel + 1 Goldbarren |
| 2/8 Golden Apple | 1 Apfel + 2 Goldbarren |
| 3/8 Golden Apple | 1 Apfel + 3 Goldbarren |
| 4/8 Golden Apple | 1 Apfel + 4 Goldbarren |
| 5/8 Golden Apple | 1 Apfel + 5 Goldbarren |
| 6/8 Golden Apple | 1 Apfel + 6 Goldbarren |
| 7/8 Golden Apple | 1 Apfel + 7 Goldbarren |

* Der **normale goldene Apfel** (8 Goldbarren + Apfel) bleibt vanilla und craftbar.
* Der **verzauberte goldene Apfel** bekommt **kein** Rezept (der „OP-Gap" aus dem Addon ist entfernt).
* Teil-Äpfel sind intern Äpfel mit Spezialkomponenten. Das Plugin verhindert, dass man sie in irgendeinem Rezept als Zutat benutzt
  (sonst ginge z. B. 1/8 + 8 Goldbarren → goldener Apfel).

## Werte (aus dem Addon)

| Stufe | Hunger | Sättigung | Absorption II | Regeneration (mit Chance) |
|---|---|---|---|---|
| 1/8 | 1 | 0,2 | 15 s | 12,5 % · II · 1 s |
| 2/8 | 1 | 0,6 | 17 s | 14,2 % · II · 1 s |
| 3/8 | 1 | 1,2 | 20 s | 16,6 % · II · 1,5 s |
| 4/8 | 1 | 1,6 | 24 s | 20 % · III · 2 s |
| 5/8 | 1 | 1,6 | 30 s | 25 % · II · 2,5 s |
| 6/8 | 1 (Addon: 1,3) | 2,6 | 40 s | 33,3 % · III · 3 s |
| 7/8 | 2 | 4,0 | 60 s | 50 % · II · 4 s |

Essdauer überall 1,6 s, immer essbar. Alles in der `config.yml` anpassbar.

## Bauen (einmalig)

Du brauchst **JDK 25** und **Maven**:

```
mvn package
```

Die fertige Datei liegt dann in `target/IncompleteGoldenApples-1.0.0.jar` → in den `plugins`-Ordner des Servers.
(Alternativ mit Gradle: `gradle build`.)

Ohne lokale Installation: Projekt in ein GitHub-Repository hochladen – die Action `.github/workflows/build.yml` baut die JAR automatisch (Reiter *Actions* → Artefakt).

Falls es einen neueren Paper-Build gibt, in der `pom.xml` die Zeile `paper.api.version` anpassen.

## Texturen (Resource Pack)

Das Pack steckt im Plugin und wird beim Start nach `plugins/IncompleteGoldenApples/IncompleteGoldenApples-ResourcePack.zip` entpackt. Zwei Wege:

1. **external** (Standard): Zip auf einen Webspace/GitHub-Release/Dropbox (direkter Download-Link!) hochladen, URL in `resource-pack.url` eintragen.
2. **builtin**: `mode: builtin`, `builtin.public-host` (Domain/IP) und einen freien Port eintragen – das Plugin hostet das Pack selbst.

Der SHA-1 wird automatisch berechnet. Ohne Pack funktionieren die Items, sehen aber aus wie normale Äpfel.

## Befehle & Rechte

| Befehl | Recht | Funktion |
|---|---|---|
| `/iga list` | – | Rezepte anzeigen |
| `/iga give <Spieler> <1-7\|all> [Anzahl]` | `iga.admin` | Teil-Äpfel geben |
| `/iga pack [Spieler]` | `iga.admin` | Resource Pack erneut senden |
| `/iga reload` | `iga.admin` | Config, Rezepte, Pack neu laden |

`iga.craft` (Standard: alle) wird nur geprüft, wenn `crafting.require-permission: true` gesetzt ist.

## Credits

Idee, Werte und Texturen stammen aus dem Bedrock-Addon „Incomplete Golden Apples" (mcpedl.com, „Modified by DangerLord"). Für den privaten Servergebrauch gedacht – vor einer Veröffentlichung des Plugins oder der Texturen bitte beim Original-Autor nachfragen.
