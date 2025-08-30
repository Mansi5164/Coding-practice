import math

def calculate_distance(x1, y1, x2, y2):
    return math.sqrt((x2 - x1)**2 + (y2 - y1)**2)

def solve():
    n = int(input())
    points = []
    for _ in range(n):
        x, y = map(int, input().split())
        points.append((x, y))

    num_bowl_points = min(6, n)
    bowl_points = points[:num_bowl_points]

    perimeter = 0
    for i in range(len(bowl_points)):
        x1, y1 = bowl_points[i]
        x2, y2 = bowl_points[(i + 1) % len(bowl_points)]
        perimeter += calculate_distance(x1, y1, x2, y2)

    print(round(perimeter))

solve()