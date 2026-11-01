
from collections import deque

start = (1, 2, 3,
         4, 0, 6,
         7, 5, 8)

goal = (1, 2, 3,
        4, 5, 6,
        7, 8, 0)

queue = deque([(start, [])])
visited = {start}

while queue:
    state, path = queue.popleft()

    if state == goal:
        print("Puzzle solved!")
        for s in path + [state]:
            print(s[:3])
            print(s[3:6])
            print(s[6:])
            print()
        print("Moves:", len(path))
        break

    zero = state.index(0)
    row, col = divmod(zero, 3)

    for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
        r, c = row + dr, col + dc

        if 0 <= r < 3 and 0 <= c < 3:
            pos = r * 3 + c
            new_state = list(state)
            new_state[zero], new_state[pos] = new_state[pos], new_state[zero]
            new_state = tuple(new_state)

            if new_state not in visited:
                visited.add(new_state)
                queue.append((new_state, path + [state]))
else:
    print("No solution found")
