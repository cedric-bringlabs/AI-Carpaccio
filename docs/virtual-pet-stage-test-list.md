# Virtual Pet Stage Test List

This stage is covered by the following intended tests.

## Construction

- A pet starts with the provided name.
- A pet starts with hunger level `0`.

## Feeding

- Feeding reduces hunger by `5`.
- Feeding does not reduce hunger below `0`.

## Time

- A single tick increases hunger by `1`.
- Hunger does not exceed `100`, even after many ticks.

## Reporting

- Status reports the pet name and current hunger in the format `name: hunger=current/max`.
