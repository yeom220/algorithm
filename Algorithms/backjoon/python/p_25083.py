arr = [
    [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ',', 'r', '\'', '"', '7'],
    ['r', '`', '-', '_', ' ', ' ', ' ', ',', '\'', ' ', ' ', ',', '/', ''],
    [' ', '\\', '.', ' ', '"', '.', ' ', 'L', '_', 'r', '\'', '', '', ''],
    [' ', ' ', ' ', '`', '~', '\\', '/', '', '', '', '', '', '', ''],
    [' ', ' ', ' ', ' ', ' ', ' ', '|', '', '', '', '', '', '', ''],
    [' ', ' ', ' ', ' ', ' ', ' ', '|', '', '', '', '', '', '', ''],
]

for inner_arr in arr:
    for i in inner_arr:
        print(i, end='')
    print()
