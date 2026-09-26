#!/usr/bin/env python3
"""Generate a new FinanceApp launcher icon at all mipmap densities.

Design: deep-teal to emerald diagonal gradient rounded square, white bold
"F" whose crossbar extends into an upward-trend arrow with a coin dot.
No external fonts: letterform and arrow are drawn as vector polygons.
"""
from PIL import Image, ImageDraw

# densities: (dir suffix, png size px)
DENSITIES = [("mdpi", 48), ("hdpi", 72), ("xhdpi", 96),
             ("xxhdpi", 144), ("xxxhdpi", 192)]

TOP = (13, 148, 136)      # teal
BOTTOM = (5, 80, 90)      # deep teal-navy
WHITE = (255, 255, 255, 255)

def gradient(size):
    img = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    px = img.load()
    for y in range(size):
        t = y / max(size - 1, 1)
        # slight diagonal feel: bias by x too
        for x in range(size):
            u = (x + y) / (2 * max(size - 1, 1))
            px[x, y] = (int(TOP[0] + (BOTTOM[0] - TOP[0]) * u),
                        int(TOP[1] + (BOTTOM[1] - TOP[1]) * u),
                        int(TOP[2] + (BOTTOM[2] - TOP[2]) * u), 255)
    return img

def rounded_mask(size, radius):
    m = Image.new("L", (size, size), 0)
    d = ImageDraw.Draw(m)
    d.rounded_rectangle([0, 0, size - 1, size - 1], radius=radius, fill=255)
    return m

def draw_mark(d, s):
    """White F + rising trend arrow, coordinates in unit space scaled by s."""
    u = s / 192.0
    # F stem
    d.polygon([(62*u, 40*u), (84*u, 40*u), (84*u, 152*u), (62*u, 152*u)], fill=WHITE)
    # F top bar
    d.polygon([(62*u, 40*u), (138*u, 40*u), (138*u, 62*u), (62*u, 62*u)], fill=WHITE)
    # trend arrow shaft: thick rising line
    d.line([(62*u, 116*u), (104*u, 116*u), (132*u, 88*u)], fill=WHITE, width=int(18*u), joint="curve")
    # arrow head at the top-right end, pointing up-right
    d.polygon([(118*u, 82*u), (150*u, 82*u), (136*u, 110*u)], fill=WHITE)


def make_icon(size):
    img = gradient(size)
    d = ImageDraw.Draw(img)
    draw_mark(d, size)
    img.putalpha(rounded_mask(size, int(size * 0.24)))
    return img

def make_foreground(size):
    """White mark on transparent, for adaptive-icon foreground."""
    img = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    d = ImageDraw.Draw(img)
    draw_mark(d, size)
    return img

def make_round(size):
    img = make_icon(size)
    m = Image.new("L", (size, size), 0)
    ImageDraw.Draw(m).ellipse([0, 0, size - 1, size - 1], fill=255)
    img.putalpha(m)
    return img

if __name__ == "__main__":
    import os, sys
    root = sys.argv[1]  # .../res
    for name, size in DENSITIES:
        dd = os.path.join(root, f"mipmap-{name}")
        os.makedirs(dd, exist_ok=True)
        make_icon(size).save(os.path.join(dd, "ic_launcher.png"))
        make_round(size).save(os.path.join(dd, "ic_launcher_round.png"))
        make_foreground(size).save(os.path.join(dd, "ic_launcher_foreground.png"))
        print(f"{name}: {size}px written")
