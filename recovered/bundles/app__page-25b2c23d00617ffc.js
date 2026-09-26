(self.webpackChunk_N_E = self.webpackChunk_N_E || []).push([
  [931],
  {
    76762: function (e, t, i) {
      Promise.resolve().then(i.bind(i, 52197));
    },
    52197: function (e, t, i) {
      "use strict";
      i.r(t),
        i.d(t, {
          default: function () {
            return em;
          },
        });
      var s = i(57437),
        n = i(2265),
        o = i(26836),
        r = i(2468),
        l = i(56689),
        a = i(47625),
        d = i(5481),
        c = i(56940),
        h = i(97059),
        f = i(62994),
        x = i(8147),
        p = i(23263),
        g = i(75169),
        u = i(3574),
        m = i(20407),
        y = i(77031),
        j = i(31699),
        b = i(59426),
        v = i(68428),
        S = i(48736),
        k = i(99397),
        z = i(9089),
        w = i(44743),
        C = i(78867),
        F = i(68919),
        R = i(88997),
        I = i(40875),
        W = i(94766),
        E = i(85929),
        B = i(97226),
        N = i(17580),
        D = i(46221),
        A = i(58896),
        T = i(71621),
        P = i(31047),
        L = i(88226),
        $ = i(73247),
        Z = i(32489),
        U = i(30401),
        M = i(92369),
        Y = i(8606),
        q = i(53581),
        O = i(30421),
        G = i(92451),
        H = i(35363),
        V = i(76858),
        X = i(11239),
        K = i(82718),
        _ = i(67782),
        J = i(92735),
        Q = i(18930),
        ee = i(82023),
        et = i(91804),
        ei = i(70525);
      let es = {
        bg: "#F1F0ED",
        ink: "#17171A",
        sub: "#9A9A9E",
        faint: "#C7C6C3",
        line: "#E7E5E1",
        green: "#22C55E",
        blue: "#0A84FF",
        orange: "#FF9F0A",
        chip: "#F4F3F0",
        leatherLight: "#6B4632",
        leatherDark: "#2E1B12",
        cardMetal1: "#3A3B3E",
        cardMetal2: "#0B0B0C",
        cardGold1: "#E8CFA0",
        cardGold2: "#9A7B4F",
      };
      function en(e) {
        let { message: t, onDone: i } = e;
        return (
          (0, n.useEffect)(() => {
            let e = setTimeout(i, 2200);
            return () => clearTimeout(e);
          }, [i]),
          (0, s.jsx)("div", {
            style: {
              position: "fixed",
              bottom: 100,
              left: "50%",
              transform: "translateX(-50%)",
              background: es.ink,
              color: "#fff",
              padding: "12px 24px",
              borderRadius: 999,
              fontSize: 14,
              fontWeight: 600,
              zIndex: 9999,
              animation: "toastIn 0.4s cubic-bezier(0.34,1.56,0.64,1) forwards",
              boxShadow: "0 8px 30px rgba(0,0,0,0.25)",
            },
            children: t,
          })
        );
      }
      function eo(e) {
        let { title: t, children: i, onClose: n } = e;
        return (0, s.jsx)("div", {
          onClick: n,
          style: {
            position: "fixed",
            inset: 0,
            background: "rgba(0,0,0,0.4)",
            zIndex: 9998,
            display: "flex",
            alignItems: "flex-end",
            justifyContent: "center",
            animation: "fadeIn 0.25s ease-out",
          },
          children: (0, s.jsxs)("div", {
            onClick: (e) => e.stopPropagation(),
            style: {
              width: "100%",
              maxWidth: 480,
              background: "#fff",
              borderRadius: "28px 28px 0 0",
              padding: "20px 24px 32px",
              animation: "slideUp 0.45s cubic-bezier(0.34,1.56,0.64,1)",
            },
            children: [
              (0, s.jsx)("div", {
                style: {
                  width: 40,
                  height: 4,
                  borderRadius: 999,
                  background: es.line,
                  margin: "0 auto 16px",
                },
              }),
              (0, s.jsx)("div", {
                style: {
                  fontSize: 18,
                  fontWeight: 700,
                  color: es.ink,
                  marginBottom: 16,
                },
                children: t,
              }),
              i,
              (0, s.jsx)("button", {
                onClick: n,
                style: {
                  width: "100%",
                  padding: "14px 0",
                  borderRadius: 999,
                  background: es.chip,
                  border: "none",
                  fontSize: 15,
                  fontWeight: 600,
                  color: es.ink,
                  marginTop: 16,
                  cursor: "pointer",
                },
                children: "Close",
              }),
            ],
          }),
        });
      }
      function er(e) {
        let { children: t, onPress: i, style: o, ...r } = e,
          [l, a] = (0, n.useState)(!1),
          { transform: d, ...c } = o || {};
        return (0, s.jsx)("button", {
          ...r,
          onMouseDown: () => a(!0),
          onMouseUp: () => a(!1),
          onMouseLeave: () => a(!1),
          onTouchStart: () => a(!0),
          onTouchEnd: () => a(!1),
          onClick: i,
          style: {
            ...c,
            transform: d || void 0,
            opacity: l ? 0.8 : 1,
            transition:
              "opacity 0.12s ease, transform 0.2s cubic-bezier(0.34,1.56,0.64,1)",
            cursor: "pointer",
            border: "none",
            outline: "none",
          },
          children: t,
        });
      }
      function el(e) {
        let { children: t, dark: i } = e,
          n = i ? "#0E0E12" : es.bg;
        return (0, s.jsx)("div", {
          style: {
            width: "100%",
            height: "100%",
            maxWidth: 480,
            margin: "0 auto",
            overflow: "hidden",
            background: n,
            position: "relative",
            display: "flex",
            flexDirection: "column",
          },
          children: t,
        });
      }
      function ea(e) {
        let { active: t, onSelect: i, onPlus: n } = e,
          o = [
            { id: "dashboard", icon: b.Z },
            { id: "spaces", icon: v.Z },
            { id: "invoice", icon: S.Z },
          ];
        return (0, s.jsxs)("div", {
          className: "flex items-center justify-between px-6 pb-6 pt-3",
          children: [
            (0, s.jsx)("div", {
              className: "flex items-center gap-1",
              style: {
                background: "#fff",
                borderRadius: 999,
                padding: 6,
                boxShadow: "0 8px 20px -8px rgba(0,0,0,0.15)",
              },
              children: o.map((e) => {
                let { id: n, icon: o } = e;
                return (0, s.jsx)(
                  er,
                  {
                    onPress: () => i(n),
                    style: {
                      width: 42,
                      height: 42,
                      borderRadius: 999,
                      display: "flex",
                      alignItems: "center",
                      justifyContent: "center",
                      transition: "all 0.2s ease",
                    },
                    children: (0, s.jsx)(o, {
                      size: 20,
                      color: t === n ? es.ink : es.sub,
                      strokeWidth: t === n ? 2.5 : 1.8,
                      style: { transition: "all 0.2s ease" },
                    }),
                  },
                  n,
                );
              }),
            }),
            (0, s.jsx)(er, {
              onPress: n,
              style: {
                width: 52,
                height: 52,
                borderRadius: 999,
                background: "#fff",
                boxShadow: "0 8px 20px -8px rgba(0,0,0,0.15)",
                display: "flex",
                alignItems: "center",
                justifyContent: "center",
              },
              children: (0, s.jsx)(k.Z, {
                size: 22,
                color: es.ink,
                strokeWidth: 2.2,
              }),
            }),
          ],
        });
      }
      function ed(e) {
        let {
            showToast: t,
            showModal: i,
            onNavigate: o,
            darkMode: y,
            toggleDarkMode: j,
          } = e,
          [v, S] = (0, n.useState)("Main Account"),
          [M, Y] = (0, n.useState)(null),
          [q, O] = (0, n.useState)(!1),
          [G, H] = (0, n.useState)(""),
          [V, X] = (0, n.useState)(!1),
          K = [
            { name: "Housing", value: 2100, color: "#FF6B6B" },
            { name: "Food", value: 850, color: "#FF9F0A" },
            { name: "Transport", value: 520, color: "#0A84FF" },
            { name: "Shopping", value: 940, color: "#8B5CF6" },
            { name: "Bills", value: 680, color: "#22C55E" },
            { name: "Other", value: 430, color: "#FF69B4" },
          ],
          _ = [
            { month: "Jan", worth: 225e3 },
            { month: "Feb", worth: 228500 },
            { month: "Mar", worth: 232e3 },
            { month: "Apr", worth: 236500 },
            { month: "May", worth: 241e3 },
            { month: "Jun", worth: 248232 },
          ],
          J = [
            { id: "Main Account", icon: (0, s.jsx)(b.Z, { size: 16 }) },
            {
              id: "Investment",
              icon: (0, s.jsx)("span", {
                style: { fontSize: 14 },
                children: "◔",
              }),
            },
            { id: "Tax Saving", icon: (0, s.jsx)(z.Z, { size: 14 }) },
          ],
          Q = [
            {
              icon: "\uD83D\uDED2",
              name: "Whole Foods",
              category: "Groceries",
              amount: "-$124.00",
              time: "2h ago",
              color: "#FFF3E0",
            },
            {
              icon: "\uD83D\uDCB0",
              name: "Salary Deposit",
              category: "Income",
              amount: "+$5,678.90",
              time: "5h ago",
              color: "#E8F5E9",
              positive: !0,
            },
            {
              icon: "☕",
              name: "Starbucks",
              category: "Food & Drink",
              amount: "-$8.50",
              time: "6h ago",
              color: "#FFF3E0",
            },
            {
              icon: "\uD83C\uDFE0",
              name: "Rent Payment",
              category: "Housing",
              amount: "-$2,100.00",
              time: "1d ago",
              color: "#E3F2FD",
            },
          ],
          ee = Q.filter(
            (e) =>
              e.name.toLowerCase().includes(G.toLowerCase()) ||
              e.category.toLowerCase().includes(G.toLowerCase()),
          ),
          et = (e) => {
            Y(e),
              i(
                "Send Money to ".concat(e.name),
                (0, s.jsxs)("div", {
                  children: [
                    (0, s.jsxs)("div", {
                      style: { textAlign: "center", padding: "10px 0" },
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            width: 60,
                            height: 60,
                            borderRadius: 999,
                            background: e.color,
                            margin: "0 auto",
                            display: "flex",
                            alignItems: "center",
                            justifyContent: "center",
                          },
                          children: (0, s.jsx)("span", {
                            style: {
                              fontSize: 24,
                              fontWeight: 700,
                              color: "#fff",
                            },
                            children: e.letter,
                          }),
                        }),
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 16,
                            fontWeight: 600,
                            color: es.ink,
                            marginTop: 12,
                          },
                          children: e.name,
                        }),
                      ],
                    }),
                    (0, s.jsx)("div", {
                      style: { display: "flex", gap: 10, marginBottom: 12 },
                      children: ["$25", "$50", "$100", "$250"].map((i) =>
                        (0, s.jsx)(
                          er,
                          {
                            onPress: () => {
                              t("Sent ".concat(i, " to ").concat(e.name, "!"));
                            },
                            style: {
                              flex: 1,
                              padding: "12px 0",
                              borderRadius: 14,
                              background: es.chip,
                              textAlign: "center",
                              fontSize: 14,
                              fontWeight: 600,
                              color: es.ink,
                            },
                            children: i,
                          },
                          i,
                        ),
                      ),
                    }),
                    (0, s.jsxs)(er, {
                      onPress: () => {
                        t("Money sent to ".concat(e.name, "!"));
                      },
                      style: {
                        width: "100%",
                        padding: "14px 0",
                        borderRadius: 999,
                        background: es.green,
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "center",
                        gap: 8,
                      },
                      children: [
                        (0, s.jsx)(w.Z, { size: 16, color: "#fff" }),
                        (0, s.jsx)("span", {
                          style: {
                            fontSize: 15,
                            fontWeight: 700,
                            color: "#fff",
                          },
                          children: "Send",
                        }),
                      ],
                    }),
                  ],
                }),
              );
          },
          ei = (e) => {
            i(
              e.name,
              (0, s.jsxs)("div", {
                children: [
                  (0, s.jsxs)("div", {
                    style: { textAlign: "center", padding: "10px 0" },
                    children: [
                      (0, s.jsx)("div", {
                        style: {
                          width: 50,
                          height: 50,
                          borderRadius: 16,
                          background: e.color,
                          margin: "0 auto",
                          display: "flex",
                          alignItems: "center",
                          justifyContent: "center",
                          fontSize: 24,
                        },
                        children: e.icon,
                      }),
                      (0, s.jsx)("div", {
                        style: {
                          fontSize: 28,
                          fontWeight: 700,
                          color: e.positive ? es.green : es.ink,
                          marginTop: 12,
                        },
                        children: e.amount,
                      }),
                      (0, s.jsxs)("div", {
                        style: { fontSize: 13, color: es.sub, marginTop: 4 },
                        children: [e.category, " \xb7 ", e.time],
                      }),
                    ],
                  }),
                  (0, s.jsxs)("div", {
                    style: { display: "flex", gap: 10, marginTop: 8 },
                    children: [
                      (0, s.jsxs)(er, {
                        onPress: () => t("Receipt saved!"),
                        style: {
                          flex: 1,
                          padding: "12px 0",
                          borderRadius: 14,
                          background: es.chip,
                          display: "flex",
                          alignItems: "center",
                          justifyContent: "center",
                          gap: 6,
                        },
                        children: [
                          (0, s.jsx)(C.Z, { size: 14, color: es.ink }),
                          " ",
                          (0, s.jsx)("span", {
                            style: {
                              fontSize: 13,
                              fontWeight: 600,
                              color: es.ink,
                            },
                            children: "Copy",
                          }),
                        ],
                      }),
                      (0, s.jsxs)(er, {
                        onPress: () => t("Shared!"),
                        style: {
                          flex: 1,
                          padding: "12px 0",
                          borderRadius: 14,
                          background: es.chip,
                          display: "flex",
                          alignItems: "center",
                          justifyContent: "center",
                          gap: 6,
                        },
                        children: [
                          (0, s.jsx)(F.Z, { size: 14, color: es.ink }),
                          " ",
                          (0, s.jsx)("span", {
                            style: {
                              fontSize: 13,
                              fontWeight: 600,
                              color: es.ink,
                            },
                            children: "Share",
                          }),
                        ],
                      }),
                      (0, s.jsxs)(er, {
                        onPress: () => t("Added to favorites!"),
                        style: {
                          flex: 1,
                          padding: "12px 0",
                          borderRadius: 14,
                          background: es.chip,
                          display: "flex",
                          alignItems: "center",
                          justifyContent: "center",
                          gap: 6,
                        },
                        children: [
                          (0, s.jsx)(R.Z, { size: 14, color: es.ink }),
                          " ",
                          (0, s.jsx)("span", {
                            style: {
                              fontSize: 13,
                              fontWeight: 600,
                              color: es.ink,
                            },
                            children: "Save",
                          }),
                        ],
                      }),
                    ],
                  }),
                ],
              }),
            );
          };
        return (0, s.jsxs)("div", {
          className: "flex flex-col h-full",
          style: { overflowY: "auto" },
          children: [
            (0, s.jsxs)("div", {
              className: "flex items-center justify-between px-6 pt-4",
              children: [
                (0, s.jsx)(er, {
                  onPress: () => t("Profile settings"),
                  style: {
                    width: 40,
                    height: 40,
                    borderRadius: 999,
                    background: "#fff",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    animation: "fadeInUp 0.4s ease-out",
                  },
                  children: (0, s.jsx)("div", {
                    style: {
                      width: 20,
                      height: 20,
                      borderRadius: 999,
                      background: es.ink,
                      position: "relative",
                    },
                    children: (0, s.jsx)("div", {
                      style: {
                        position: "absolute",
                        inset: 5,
                        borderRadius: 999,
                        background: "#fff",
                      },
                    }),
                  }),
                }),
                (0, s.jsxs)(er, {
                  onPress: () => O(!0),
                  style: {
                    background: "#fff",
                    borderRadius: 999,
                    padding: "8px 16px",
                    display: "flex",
                    alignItems: "center",
                    gap: 6,
                    animation: "fadeInUp 0.4s ease-out 0.05s both",
                  },
                  children: [
                    (0, s.jsx)("span", {
                      style: { fontSize: 14, fontWeight: 600, color: es.ink },
                      children: "All Wallets",
                    }),
                    (0, s.jsx)(I.Z, { size: 14, color: es.sub }),
                  ],
                }),
                (0, s.jsx)(er, {
                  onPress: async () => {
                    if (l.dV.isNativePlatform())
                      try {
                        let e = await r.s.requestPermissions();
                        "granted" === e.display
                          ? (await r.s.schedule({
                              notifications: [
                                {
                                  title: "Finance App",
                                  body: "Notifications are now enabled! You'll receive alerts for transactions.",
                                  id: 1,
                                  schedule: { at: new Date(Date.now() + 2e3) },
                                },
                              ],
                            }),
                            t("Notifications enabled ✓"))
                          : t("Notification permission denied");
                      } catch (e) {
                        console.log("Notification error:", e),
                          t("Notifications enabled ✓");
                      }
                    else t("Notifications enabled ✓");
                  },
                  style: {
                    width: 40,
                    height: 40,
                    borderRadius: 999,
                    background: "linear-gradient(135deg,#d9c7a3,#8a6c4a)",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    animation: "fadeInUp 0.4s ease-out 0.1s both",
                  },
                  children: (0, s.jsx)(W.Z, { size: 16, color: "#fff" }),
                }),
                (0, s.jsx)(er, {
                  onPress: j,
                  style: {
                    width: 40,
                    height: 40,
                    borderRadius: 999,
                    background: "#fff",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    animation: "fadeInUp 0.4s ease-out 0.15s both",
                  },
                  children: y
                    ? (0, s.jsx)(E.Z, { size: 16, color: "#FF9F0A" })
                    : (0, s.jsx)(B.Z, { size: 16, color: es.ink }),
                }),
              ],
            }),
            (0, s.jsxs)("div", {
              className: "px-6 pt-5",
              style: { animation: "fadeInUp 0.5s ease-out" },
              children: [
                (0, s.jsx)("div", {
                  style: { color: es.sub, fontSize: 14, fontWeight: 500 },
                  children: "Balance",
                }),
                (0, s.jsx)("div", {
                  className: "flex items-end gap-3 pt-1",
                  children: (0, s.jsxs)("div", {
                    style: {
                      fontSize: 34,
                      fontWeight: 700,
                      color: es.ink,
                      letterSpacing: -1,
                    },
                    children: [
                      "$248,232",
                      (0, s.jsx)("span", {
                        style: { color: es.faint },
                        children: ".53",
                      }),
                    ],
                  }),
                }),
                (0, s.jsxs)("div", {
                  className: "flex items-center gap-1.5 pt-1",
                  children: [
                    (0, s.jsx)("div", {
                      className: "flex items-center justify-center",
                      style: {
                        width: 18,
                        height: 18,
                        borderRadius: 999,
                        background: es.green,
                      },
                      children: (0, s.jsx)(N.Z, {
                        size: 11,
                        color: "#fff",
                        strokeWidth: 3,
                      }),
                    }),
                    (0, s.jsx)("span", {
                      style: { fontSize: 13, fontWeight: 600, color: es.ink },
                      children: "+23.65%",
                    }),
                  ],
                }),
              ],
            }),
            (0, s.jsx)("div", {
              className: "px-6 pt-3",
              style: {
                perspective: 1e3,
                animation: "fadeInUp 0.6s ease-out 0.1s both",
              },
              children: (0, s.jsxs)("div", {
                style: {
                  position: "relative",
                  width: "100%",
                  maxWidth: 340,
                  margin: "0 auto",
                  aspectRatio: "300 / 260",
                },
                children: [
                  (0, s.jsx)("div", {
                    style: {
                      position: "absolute",
                      top: 0,
                      left: "3%",
                      width: "93%",
                      height: "67%",
                      borderRadius: "7% / 10%",
                      background: "repeating-linear-gradient(100deg, "
                        .concat(es.cardMetal1, " 0px, ")
                        .concat(es.cardMetal1, " 2px, ")
                        .concat(es.cardMetal2, " 3px, ")
                        .concat(es.cardMetal1, " 5px)"),
                      boxShadow: "0 20px 30px -15px rgba(0,0,0,0.4)",
                      transform: "rotateX(4deg)",
                    },
                  }),
                  (0, s.jsx)("div", {
                    style: {
                      position: "absolute",
                      top: "16%",
                      left: "3%",
                      width: "93%",
                      height: "58%",
                      borderRadius: "7% / 12%",
                      background: "linear-gradient(135deg, "
                        .concat(es.cardGold1, ", ")
                        .concat(es.cardGold2, ")"),
                      boxShadow: "0 20px 34px -14px rgba(0,0,0,0.35)",
                    },
                    children: (0, s.jsxs)("div", {
                      className: "flex items-center justify-between px-5 pt-5",
                      children: [
                        (0, s.jsx)("span", {
                          style: {
                            fontFamily: "Georgia, serif",
                            fontSize: 22,
                            color: "#3d2e1a",
                            fontStyle: "italic",
                          },
                          children: "Savior",
                        }),
                        (0, s.jsx)("span", {
                          style: {
                            fontSize: 12,
                            fontWeight: 600,
                            color: "#5b4326",
                            letterSpacing: 0.5,
                          },
                          children: "Business",
                        }),
                      ],
                    }),
                  }),
                  (0, s.jsx)("div", {
                    style: {
                      position: "absolute",
                      bottom: 0,
                      left: 0,
                      width: "100%",
                      height: "58%",
                      borderRadius: "9% 9% 11% 11%",
                      background: "linear-gradient(160deg, "
                        .concat(es.leatherLight, ", ")
                        .concat(es.leatherDark, ")"),
                      boxShadow:
                        "0 24px 40px -16px rgba(0,0,0,0.5), inset 0 1px 0 rgba(255,255,255,0.08)",
                    },
                    children: (0, s.jsx)("div", {
                      style: {
                        position: "absolute",
                        top: 14,
                        left: "50%",
                        transform: "translateX(-50%)",
                        width: 40,
                        height: 14,
                        borderRadius: 999,
                        background: "rgba(0,0,0,0.35)",
                      },
                    }),
                  }),
                ],
              }),
            }),
            (0, s.jsx)("div", {
              className: "flex gap-3 px-6 pt-5",
              style: { animation: "fadeInUp 0.5s ease-out 0.2s both" },
              children: J.map((e) =>
                (0, s.jsxs)(
                  er,
                  {
                    onPress: () => {
                      S(e.id), t("Switched to ".concat(e.id));
                    },
                    style: {
                      flex: 1,
                      minWidth: 0,
                      borderRadius: 18,
                      background: v === e.id ? es.ink : "#fff",
                      textAlign: "left",
                      padding: "12px 10px",
                      display: "flex",
                      flexDirection: "column",
                      gap: 8,
                    },
                    children: [
                      (0, s.jsx)("span", {
                        className: "flex items-center justify-center",
                        style: {
                          width: 26,
                          height: 26,
                          borderRadius: 8,
                          background:
                            v === e.id ? "rgba(255,255,255,0.15)" : es.chip,
                          color: v === e.id ? "#fff" : es.ink,
                        },
                        children: e.icon,
                      }),
                      (0, s.jsx)("span", {
                        style: {
                          fontSize: 12.5,
                          fontWeight: 600,
                          color: v === e.id ? "#fff" : es.ink,
                          lineHeight: 1.2,
                        },
                        children: e.id,
                      }),
                    ],
                  },
                  e.id,
                ),
              ),
            }),
            (0, s.jsxs)("div", {
              className: "px-6 pt-3",
              style: { animation: "fadeInUp 0.5s ease-out 0.25s both" },
              children: [
                (0, s.jsxs)("div", {
                  className: "flex items-center justify-between mb-3",
                  children: [
                    (0, s.jsx)("span", {
                      style: { fontSize: 15, fontWeight: 600, color: es.ink },
                      children: "Cashflow",
                    }),
                    (0, s.jsx)(er, {
                      onPress: () => t("View cashflow details"),
                      style: {
                        padding: "5px 12px",
                        borderRadius: 999,
                        background: es.chip,
                      },
                      children: (0, s.jsx)("span", {
                        style: { fontSize: 12, fontWeight: 600, color: es.sub },
                        children: "View All →",
                      }),
                    }),
                  ],
                }),
                (0, s.jsxs)("div", {
                  style: { display: "flex", gap: 10 },
                  children: [
                    (0, s.jsxs)("div", {
                      style: {
                        flex: 1,
                        padding: "14px 16px",
                        borderRadius: 16,
                        background: "#fff",
                      },
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 11.5,
                            color: es.sub,
                            fontWeight: 500,
                          },
                          children: "Income",
                        }),
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 17,
                            fontWeight: 700,
                            color: es.ink,
                            marginTop: 4,
                          },
                          children: "$8,250",
                        }),
                        (0, s.jsx)("div", {
                          style: {
                            height: 6,
                            borderRadius: 999,
                            background: es.chip,
                            marginTop: 10,
                            overflow: "hidden",
                          },
                          children: (0, s.jsx)("div", {
                            style: {
                              height: "100%",
                              width: "72%",
                              borderRadius: 999,
                              background: es.green,
                            },
                          }),
                        }),
                      ],
                    }),
                    (0, s.jsxs)("div", {
                      style: {
                        flex: 1,
                        padding: "14px 16px",
                        borderRadius: 16,
                        background: "#fff",
                      },
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 11.5,
                            color: es.sub,
                            fontWeight: 500,
                          },
                          children: "Expenses",
                        }),
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 17,
                            fontWeight: 700,
                            color: es.ink,
                            marginTop: 4,
                          },
                          children: "$4,120",
                        }),
                        (0, s.jsx)("div", {
                          style: {
                            height: 6,
                            borderRadius: 999,
                            background: es.chip,
                            marginTop: 10,
                            overflow: "hidden",
                          },
                          children: (0, s.jsx)("div", {
                            style: {
                              height: "100%",
                              width: "38%",
                              borderRadius: 999,
                              background: es.orange,
                            },
                          }),
                        }),
                      ],
                    }),
                  ],
                }),
              ],
            }),
            (0, s.jsx)("div", {
              className: "px-6 pt-4",
              style: { animation: "fadeInUp 0.5s ease-out 0.25s both" },
              children: (0, s.jsx)("div", {
                className: "flex gap-2 overflow-x-auto pb-1",
                style: { scrollbarWidth: "none" },
                children: [
                  {
                    icon: (0, s.jsx)(D.Z, { size: 16 }),
                    label: "Analytics",
                    color: "#8B5CF6",
                    bg: "#EDE9FE",
                    action: () => o("analytics"),
                  },
                  {
                    icon: (0, s.jsx)(A.Z, { size: 16 }),
                    label: "Budgets",
                    color: "#22C55E",
                    bg: "#E8F5E9",
                    action: () => o("budgets"),
                  },
                  {
                    icon: (0, s.jsx)(T.Z, { size: 16 }),
                    label: "Subscriptions",
                    color: "#FF9F0A",
                    bg: "#FFF3E0",
                    action: () => o("subscriptions"),
                  },
                  {
                    icon: (0, s.jsx)(P.Z, { size: 16 }),
                    label: "Net Worth",
                    color: "#0A84FF",
                    bg: "#E3F2FD",
                    action: () =>
                      i(
                        "Net Worth Trend",
                        (0, s.jsx)("div", {
                          style: { height: 280 },
                          children: (0, s.jsx)(a.h, {
                            width: "100%",
                            height: "100%",
                            children: (0, s.jsxs)(d.T, {
                              data: _,
                              children: [
                                (0, s.jsx)("defs", {
                                  children: (0, s.jsxs)("linearGradient", {
                                    id: "nwGrad",
                                    x1: "0",
                                    y1: "0",
                                    x2: "0",
                                    y2: "1",
                                    children: [
                                      (0, s.jsx)("stop", {
                                        offset: "5%",
                                        stopColor: "#22C55E",
                                        stopOpacity: 0.3,
                                      }),
                                      (0, s.jsx)("stop", {
                                        offset: "95%",
                                        stopColor: "#22C55E",
                                        stopOpacity: 0,
                                      }),
                                    ],
                                  }),
                                }),
                                (0, s.jsx)(c.q, {
                                  strokeDasharray: "3 3",
                                  stroke: "#E7E5E1",
                                }),
                                (0, s.jsx)(h.K, {
                                  dataKey: "month",
                                  fontSize: 12,
                                  tick: { fill: "#9A9A9E" },
                                }),
                                (0, s.jsx)(f.B, {
                                  fontSize: 12,
                                  tick: { fill: "#9A9A9E" },
                                  tickFormatter: (e) =>
                                    "$".concat((e / 1e3).toFixed(0), "k"),
                                }),
                                (0, s.jsx)(x.u, {
                                  formatter: (e) => [
                                    "$".concat(e.toLocaleString()),
                                    "Net Worth",
                                  ],
                                }),
                                (0, s.jsx)(p.u, {
                                  type: "monotone",
                                  dataKey: "worth",
                                  stroke: "#22C55E",
                                  fill: "url(#nwGrad)",
                                  strokeWidth: 2,
                                }),
                              ],
                            }),
                          }),
                        }),
                      ),
                  },
                  {
                    icon: (0, s.jsx)(L.Z, { size: 16 }),
                    label: "Spending",
                    color: "#FF6B6B",
                    bg: "#FBE1E1",
                    action: () =>
                      i(
                        "Spending by Category",
                        (0, s.jsx)("div", {
                          style: {
                            height: 280,
                            display: "flex",
                            alignItems: "center",
                            justifyContent: "center",
                          },
                          children: (0, s.jsx)(a.h, {
                            width: "100%",
                            height: "100%",
                            children: (0, s.jsxs)(g.u, {
                              children: [
                                (0, s.jsx)(u.b, {
                                  data: K,
                                  cx: "50%",
                                  cy: "50%",
                                  innerRadius: 55,
                                  outerRadius: 100,
                                  paddingAngle: 4,
                                  dataKey: "value",
                                  children: K.map((e, t) =>
                                    (0, s.jsx)(
                                      m.b,
                                      { fill: e.color, stroke: "none" },
                                      t,
                                    ),
                                  ),
                                }),
                                (0, s.jsx)(x.u, {
                                  formatter: (e) => ["$".concat(e), "Spent"],
                                }),
                              ],
                            }),
                          }),
                        }),
                      ),
                  },
                ].map((e) =>
                  (0, s.jsxs)(
                    er,
                    {
                      onPress: e.action,
                      style: {
                        display: "flex",
                        alignItems: "center",
                        gap: 8,
                        padding: "10px 16px",
                        borderRadius: 999,
                        background: e.bg,
                        whiteSpace: "nowrap",
                        transition: "all 0.2s ease",
                      },
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            width: 28,
                            height: 28,
                            borderRadius: 8,
                            background: e.color + "20",
                            display: "flex",
                            alignItems: "center",
                            justifyContent: "center",
                            color: e.color,
                          },
                          children: e.icon,
                        }),
                        (0, s.jsx)("span", {
                          style: {
                            fontSize: 13,
                            fontWeight: 600,
                            color: es.ink,
                          },
                          children: e.label,
                        }),
                      ],
                    },
                    e.label,
                  ),
                ),
              }),
            }),
            (0, s.jsx)("div", {
              className: "px-6 pt-2",
              style: { animation: "fadeInUp 0.4s ease-out 0.28s both" },
              children: (0, s.jsxs)("div", {
                className: "flex items-center gap-2",
                style: {
                  background: "#fff",
                  borderRadius: 14,
                  padding: "4px 14px",
                },
                children: [
                  (0, s.jsx)($.Z, { size: 16, color: es.sub }),
                  (0, s.jsx)("input", {
                    type: "text",
                    placeholder: "Search transactions...",
                    value: G,
                    onChange: (e) => H(e.target.value),
                    style: {
                      flex: 1,
                      padding: "10px 0",
                      border: "none",
                      background: "transparent",
                      fontSize: 13.5,
                      fontWeight: 500,
                      color: es.ink,
                      outline: "none",
                      fontFamily: "inherit",
                    },
                  }),
                  G &&
                    (0, s.jsx)(er, {
                      onPress: () => H(""),
                      style: {
                        width: 22,
                        height: 22,
                        borderRadius: 999,
                        background: es.chip,
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "center",
                      },
                      children: (0, s.jsx)(Z.Z, { size: 12, color: es.sub }),
                    }),
                ],
              }),
            }),
            (0, s.jsxs)("div", {
              className: "px-6 pt-3",
              style: { animation: "fadeInUp 0.5s ease-out 0.3s both" },
              children: [
                (0, s.jsxs)("div", {
                  className: "flex items-center justify-between",
                  children: [
                    (0, s.jsx)("span", {
                      style: { fontSize: 15, fontWeight: 600, color: es.ink },
                      children: "Send Money",
                    }),
                    (0, s.jsx)(er, {
                      onPress: () => t("View all contacts"),
                      style: {
                        padding: "4px 10px",
                        borderRadius: 999,
                        background: es.chip,
                      },
                      children: (0, s.jsx)("span", {
                        style: { fontSize: 12, fontWeight: 600, color: es.sub },
                        children: "View All →",
                      }),
                    }),
                  ],
                }),
                (0, s.jsxs)("div", {
                  className: "flex gap-3 pt-4",
                  children: [
                    [
                      { name: "Emma", color: "#FF6B6B", letter: "E" },
                      { name: "Noah", color: "#4ECDC4", letter: "N" },
                      { name: "Olivia", color: "#45B7D1", letter: "O" },
                      { name: "Liam", color: "#96CEB4", letter: "L" },
                    ].map((e) =>
                      (0, s.jsxs)(
                        er,
                        {
                          onPress: () => et(e),
                          style: { flex: 1, textAlign: "center" },
                          children: [
                            (0, s.jsx)("div", {
                              style: {
                                width: 48,
                                height: 48,
                                borderRadius: 999,
                                background: e.color,
                                margin: "0 auto",
                                display: "flex",
                                alignItems: "center",
                                justifyContent: "center",
                                boxShadow: "0 4px 12px ".concat(e.color, "40"),
                              },
                              children: (0, s.jsx)("span", {
                                style: {
                                  fontSize: 18,
                                  fontWeight: 700,
                                  color: "#fff",
                                },
                                children: e.letter,
                              }),
                            }),
                            (0, s.jsx)("span", {
                              style: {
                                fontSize: 11,
                                fontWeight: 500,
                                color: es.sub,
                                marginTop: 6,
                                display: "block",
                              },
                              children: e.name,
                            }),
                          ],
                        },
                        e.name,
                      ),
                    ),
                    (0, s.jsxs)(er, {
                      onPress: () => t("Add new contact"),
                      style: { flex: 1, textAlign: "center" },
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            width: 48,
                            height: 48,
                            borderRadius: 999,
                            background: es.chip,
                            margin: "0 auto",
                            display: "flex",
                            alignItems: "center",
                            justifyContent: "center",
                          },
                          children: (0, s.jsx)(k.Z, {
                            size: 20,
                            color: es.sub,
                          }),
                        }),
                        (0, s.jsx)("span", {
                          style: {
                            fontSize: 11,
                            fontWeight: 500,
                            color: es.sub,
                            marginTop: 6,
                            display: "block",
                          },
                          children: "Add",
                        }),
                      ],
                    }),
                  ],
                }),
              ],
            }),
            (0, s.jsxs)("div", {
              className: "px-6 pt-4 pb-4",
              style: { animation: "fadeInUp 0.5s ease-out 0.4s both" },
              children: [
                (0, s.jsxs)("div", {
                  className: "flex items-center justify-between",
                  children: [
                    (0, s.jsx)("span", {
                      style: { fontSize: 15, fontWeight: 600, color: es.ink },
                      children: "Recent Transactions",
                    }),
                    (0, s.jsx)(er, {
                      onPress: () => t("View all transactions"),
                      style: {
                        padding: "4px 10px",
                        borderRadius: 999,
                        background: es.chip,
                      },
                      children: (0, s.jsx)("span", {
                        style: { fontSize: 12, fontWeight: 600, color: es.sub },
                        children: "View All →",
                      }),
                    }),
                  ],
                }),
                (0, s.jsx)("div", {
                  className: "flex flex-col gap-2.5 pt-3",
                  children: (G ? ee : Q).map((e, t) =>
                    (0, s.jsxs)(
                      er,
                      {
                        onPress: () => ei(e),
                        style: {
                          display: "flex",
                          alignItems: "center",
                          gap: 12,
                          padding: "12px 14px",
                          background: "#fff",
                          borderRadius: 16,
                          animation: "fadeInUp 0.4s ease-out ".concat(
                            0.5 + 0.08 * t,
                            "s both",
                          ),
                        },
                        children: [
                          (0, s.jsx)("div", {
                            style: {
                              width: 42,
                              height: 42,
                              borderRadius: 14,
                              background: e.color,
                              display: "flex",
                              alignItems: "center",
                              justifyContent: "center",
                              fontSize: 20,
                            },
                            children: e.icon,
                          }),
                          (0, s.jsxs)("div", {
                            style: { flex: 1, minWidth: 0 },
                            children: [
                              (0, s.jsx)("div", {
                                style: {
                                  fontSize: 14,
                                  fontWeight: 600,
                                  color: es.ink,
                                },
                                children: e.name,
                              }),
                              (0, s.jsx)("div", {
                                style: { fontSize: 11.5, color: es.sub },
                                children: e.category,
                              }),
                            ],
                          }),
                          (0, s.jsxs)("div", {
                            style: { textAlign: "right" },
                            children: [
                              (0, s.jsx)("div", {
                                style: {
                                  fontSize: 14,
                                  fontWeight: 700,
                                  color: e.positive ? es.green : es.ink,
                                },
                                children: e.amount,
                              }),
                              (0, s.jsx)("div", {
                                style: { fontSize: 11, color: es.sub },
                                children: e.time,
                              }),
                            ],
                          }),
                        ],
                      },
                      t,
                    ),
                  ),
                }),
              ],
            }),
            q &&
              (0, s.jsx)(eo, {
                title: "Select Wallet",
                onClose: () => O(!1),
                children: [
                  "Main Account",
                  "Investment",
                  "Tax Saving",
                  "Savings",
                ].map((e) =>
                  (0, s.jsxs)(
                    er,
                    {
                      onPress: () => {
                        S(e), O(!1), t("Switched to ".concat(e));
                      },
                      style: {
                        display: "flex",
                        alignItems: "center",
                        gap: 12,
                        padding: "14px 0",
                        borderBottom: "1px solid ".concat(es.line),
                      },
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            width: 36,
                            height: 36,
                            borderRadius: 12,
                            background: v === e ? es.ink : es.chip,
                            display: "flex",
                            alignItems: "center",
                            justifyContent: "center",
                          },
                          children:
                            v === e &&
                            (0, s.jsx)(U.Z, {
                              size: 16,
                              color: "#fff",
                              strokeWidth: 3,
                            }),
                        }),
                        (0, s.jsx)("span", {
                          style: {
                            fontSize: 15,
                            fontWeight: 600,
                            color: es.ink,
                          },
                          children: e,
                        }),
                      ],
                    },
                    e,
                  ),
                ),
              }),
          ],
        });
      }
      function ec(e) {
        let { showToast: t, showModal: i, onNavigate: o } = e,
          [r, l] = (0, n.useState)(["Vacation"]),
          [a, d] = (0, n.useState)(["New Camera"]),
          [c, h] = (0, n.useState)(!1),
          f = [
            {
              id: "Personal",
              amount: "$50,250",
              icon: (0, s.jsx)(M.Z, { size: 16, color: "#3B82F6" }),
              tile: "#DCEBFF",
            },
            {
              id: "Tax",
              amount: "$32,850",
              icon: (0, s.jsx)(z.Z, { size: 15, color: "#6B6B6E" }),
              tile: "#EDECE9",
            },
            {
              id: "Savings",
              amount: "$50,250",
              icon: (0, s.jsx)(b.Z, { size: 15, color: "#6B6B6E" }),
              tile: "#EDECE9",
            },
            {
              id: "Vacation",
              amount: "$1,520",
              icon: (0, s.jsx)(Y.Z, { size: 16, color: "#EF6E6E" }),
              tile: "#FBE1E1",
            },
          ],
          x = [
            {
              id: "New Camera",
              amount: "$3,230",
              icon: (0, s.jsx)(q.Z, { size: 30, color: "#3f3f3f" }),
            },
            {
              id: "New bike",
              amount: "$5,300",
              icon: (0, s.jsx)(O.Z, { size: 30, color: "#3f3f3f" }),
            },
          ],
          p = (e) => {
            l((t) => (t.includes(e) ? t.filter((t) => t !== e) : [...t, e]));
          },
          g = (e) => {
            d((t) => (t.includes(e) ? t.filter((t) => t !== e) : [...t, e]));
          },
          u =
            f
              .filter((e) => r.includes(e.id))
              .reduce(
                (e, t) => e + parseInt(t.amount.replace(/[$,]/g, "")),
                0,
              ) +
            x
              .filter((e) => a.includes(e.id))
              .reduce((e, t) => e + parseInt(t.amount.replace(/[$,]/g, "")), 0);
        return (0, s.jsxs)("div", {
          className: "flex flex-col h-full",
          style: { background: "#E9E8E5", overflowY: "auto" },
          children: [
            (0, s.jsxs)("div", {
              className: "flex items-center justify-between px-6 pt-3",
              children: [
                (0, s.jsx)(er, {
                  onPress: () => {
                    o("dashboard"), t("Back to Dashboard");
                  },
                  style: {
                    width: 40,
                    height: 40,
                    borderRadius: 999,
                    background: "#fff",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    animation: "fadeInUp 0.4s ease-out",
                  },
                  children: (0, s.jsx)(G.Z, { size: 18, color: es.ink }),
                }),
                (0, s.jsxs)("div", {
                  className: "text-center",
                  style: { flex: 1 },
                  children: [
                    (0, s.jsx)("div", {
                      style: { fontSize: 17, fontWeight: 700, color: es.ink },
                      children: "Spaces",
                    }),
                    (0, s.jsx)("div", {
                      style: { fontSize: 12, color: es.sub },
                      children: "Select spaces to move from",
                    }),
                  ],
                }),
                (0, s.jsx)(er, {
                  onPress: () => h(!0),
                  style: {
                    width: 40,
                    height: 40,
                    borderRadius: 999,
                    background: "#fff",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    animation: "fadeInUp 0.4s ease-out 0.1s both",
                  },
                  children: (0, s.jsx)(H.Z, { size: 16, color: es.ink }),
                }),
              ],
            }),
            (0, s.jsx)("div", {
              className: "grid grid-cols-2 gap-3 px-6 pt-5",
              children: f.map((e, t) => {
                let i = r.includes(e.id);
                return (0, s.jsxs)(
                  er,
                  {
                    onPress: () => p(e.id),
                    style: {
                      padding: 16,
                      background: "#fff",
                      borderRadius: 20,
                      border: i
                        ? "2px solid ".concat(es.blue)
                        : "2px solid transparent",
                      position: "relative",
                      animation: "fadeInUp 0.4s ease-out ".concat(
                        0.08 * t,
                        "s both",
                      ),
                      transition: "all 0.25s ease",
                      transform: i ? "scale(1.02)" : "scale(1)",
                    },
                    children: [
                      (0, s.jsx)("div", {
                        className: "flex items-center justify-center",
                        style: {
                          width: 36,
                          height: 36,
                          borderRadius: 12,
                          background: e.tile,
                        },
                        children: e.icon,
                      }),
                      (0, s.jsx)("div", {
                        className: "pt-6",
                        style: {
                          fontSize: 14.5,
                          fontWeight: 600,
                          color: es.ink,
                        },
                        children: e.id,
                      }),
                      (0, s.jsxs)("div", {
                        className: "flex items-center justify-between pt-0.5",
                        children: [
                          (0, s.jsx)("span", {
                            style: {
                              fontSize: 14,
                              fontWeight: 700,
                              color: es.ink,
                            },
                            children: e.amount,
                          }),
                          (0, s.jsx)("div", {
                            className: "flex items-center justify-center",
                            style: {
                              width: 24,
                              height: 24,
                              borderRadius: 999,
                              background: i ? es.blue : es.chip,
                              transition: "background 0.2s ease",
                            },
                            children: i
                              ? (0, s.jsx)(U.Z, {
                                  size: 13,
                                  color: "#fff",
                                  strokeWidth: 3,
                                })
                              : (0, s.jsx)(k.Z, { size: 13, color: es.sub }),
                          }),
                        ],
                      }),
                    ],
                  },
                  e.id,
                );
              }),
            }),
            (0, s.jsx)("div", {
              className: "flex items-center gap-2 px-6 pt-5",
              children: (0, s.jsx)("span", {
                style: { fontSize: 13, fontWeight: 600, color: es.ink },
                children: "◎ Goals",
              }),
            }),
            (0, s.jsx)("div", {
              className: "grid grid-cols-2 gap-3 px-6 pt-2",
              children: x.map((e, t) => {
                let i = a.includes(e.id);
                return (0, s.jsxs)(
                  er,
                  {
                    onPress: () => g(e.id),
                    style: {
                      background: "#fff",
                      borderRadius: 20,
                      overflow: "hidden",
                      border: i
                        ? "2px solid ".concat(es.blue)
                        : "2px solid transparent",
                      animation: "fadeInUp 0.4s ease-out ".concat(
                        0.3 + 0.08 * t,
                        "s both",
                      ),
                      transition: "all 0.25s ease",
                      transform: i ? "scale(1.02)" : "scale(1)",
                    },
                    children: [
                      (0, s.jsx)("div", {
                        className: "flex items-center justify-center",
                        style: { height: 90, background: "#EFEEEC" },
                        children: e.icon,
                      }),
                      (0, s.jsxs)("div", {
                        className: "p-3",
                        children: [
                          (0, s.jsx)("div", {
                            style: {
                              fontSize: 14,
                              fontWeight: 600,
                              color: es.ink,
                            },
                            children: e.id,
                          }),
                          (0, s.jsxs)("div", {
                            className:
                              "flex items-center justify-between pt-0.5",
                            children: [
                              (0, s.jsx)("span", {
                                style: {
                                  fontSize: 14,
                                  fontWeight: 700,
                                  color: es.ink,
                                },
                                children: e.amount,
                              }),
                              (0, s.jsx)("div", {
                                className: "flex items-center justify-center",
                                style: {
                                  width: 24,
                                  height: 24,
                                  borderRadius: 999,
                                  background: i ? es.blue : es.chip,
                                  transition: "background 0.2s ease",
                                },
                                children: i
                                  ? (0, s.jsx)(U.Z, {
                                      size: 13,
                                      color: "#fff",
                                      strokeWidth: 3,
                                    })
                                  : (0, s.jsx)(k.Z, {
                                      size: 13,
                                      color: es.sub,
                                    }),
                              }),
                            ],
                          }),
                        ],
                      }),
                    ],
                  },
                  e.id,
                );
              }),
            }),
            (0, s.jsx)("div", { className: "flex-1" }),
            (0, s.jsxs)("div", {
              className: "flex items-center justify-between px-6 pb-5 pt-4",
              style: { animation: "fadeInUp 0.4s ease-out 0.5s both" },
              children: [
                (0, s.jsx)(er, {
                  onPress: () => {
                    o("dashboard"), t("Back to Dashboard");
                  },
                  style: {
                    width: 48,
                    height: 48,
                    borderRadius: 999,
                    background: "#fff",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                  },
                  children: (0, s.jsx)(G.Z, { size: 18, color: es.ink }),
                }),
                (0, s.jsxs)("div", {
                  className: "flex items-center gap-3 px-2 py-1.5",
                  style: {
                    background: "#fff",
                    borderRadius: 999,
                    flex: 1,
                    margin: "0 12px",
                  },
                  children: [
                    (0, s.jsx)("div", {
                      className: "flex items-center justify-center",
                      style: {
                        width: 32,
                        height: 32,
                        borderRadius: 999,
                        background: es.chip,
                        marginLeft: 4,
                      },
                      children: (0, s.jsx)(b.Z, { size: 14, color: es.ink }),
                    }),
                    (0, s.jsxs)("div", {
                      style: { lineHeight: 1.15 },
                      children: [
                        (0, s.jsxs)("div", {
                          style: {
                            fontSize: 13,
                            fontWeight: 700,
                            color: es.ink,
                          },
                          children: [r.length + a.length, " Spaces"],
                        }),
                        (0, s.jsx)("div", {
                          style: { fontSize: 11, color: es.sub },
                          children: "Selected",
                        }),
                      ],
                    }),
                    (0, s.jsx)("div", { style: { flex: 1 } }),
                    (0, s.jsxs)("div", {
                      style: {
                        background: es.ink,
                        color: "#fff",
                        fontSize: 14,
                        fontWeight: 700,
                        padding: "8px 14px",
                        borderRadius: 999,
                      },
                      children: ["$", u.toLocaleString()],
                    }),
                  ],
                }),
                (0, s.jsx)(er, {
                  onPress: () => t("Transferred $".concat(u.toLocaleString())),
                  style: {
                    width: 48,
                    height: 48,
                    borderRadius: 999,
                    background: es.blue,
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                  },
                  children: (0, s.jsx)(V.Z, { size: 18, color: "#fff" }),
                }),
              ],
            }),
            c &&
              (0, s.jsx)(eo, {
                title: "Filter Spaces",
                onClose: () => h(!1),
                children: ["All", "Active", "Inactive", "Goals Only"].map((e) =>
                  (0, s.jsxs)(
                    er,
                    {
                      onPress: () => {
                        h(!1), t("Filter: ".concat(e));
                      },
                      style: {
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "space-between",
                        padding: "14px 0",
                        borderBottom: "1px solid ".concat(es.line),
                      },
                      children: [
                        (0, s.jsx)("span", {
                          style: {
                            fontSize: 15,
                            fontWeight: 500,
                            color: es.ink,
                          },
                          children: e,
                        }),
                        (0, s.jsx)("div", {
                          style: {
                            width: 22,
                            height: 22,
                            borderRadius: 999,
                            border: "2px solid ".concat(es.line),
                            display: "flex",
                            alignItems: "center",
                            justifyContent: "center",
                          },
                        }),
                      ],
                    },
                    e,
                  ),
                ),
              }),
          ],
        });
      }
      function eh(e) {
        let { showToast: t, showModal: i, onNavigate: o } = e,
          [r, l] = (0, n.useState)(!1),
          [a, d] = (0, n.useState)(!0),
          [c, h] = (0, n.useState)(!1);
        return (0, s.jsxs)("div", {
          className: "flex flex-col h-full",
          style: { background: "#EDECE9", overflowY: "auto" },
          children: [
            (0, s.jsxs)("div", {
              className: "flex items-center justify-between px-5 pt-3",
              children: [
                (0, s.jsx)(er, {
                  onPress: () => {
                    o("dashboard");
                  },
                  style: {
                    width: 40,
                    height: 40,
                    borderRadius: 999,
                    background: "#fff",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    animation: "fadeInUp 0.4s ease-out",
                  },
                  children: (0, s.jsx)(G.Z, { size: 16, color: es.ink }),
                }),
                (0, s.jsx)(er, {
                  onPress: () => t("Invoice IN-001"),
                  style: {
                    background: "#fff",
                    borderRadius: 999,
                    padding: "6px 16px",
                    fontFamily: "monospace",
                    fontSize: 13,
                    fontWeight: 600,
                    color: es.ink,
                    animation: "fadeInUp 0.4s ease-out 0.05s both",
                  },
                  children: "IN-001",
                }),
                (0, s.jsx)(er, {
                  onPress: () => t("Send message"),
                  style: {
                    width: 40,
                    height: 40,
                    borderRadius: 999,
                    background: "#fff",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    animation: "fadeInUp 0.4s ease-out 0.1s both",
                  },
                  children: (0, s.jsx)(K.Z, { size: 16, color: es.ink }),
                }),
              ],
            }),
            (0, s.jsxs)("div", {
              className: "mx-5 mt-3 p-5",
              style: {
                background: "#fff",
                borderRadius: 24,
                flex: 1,
                animation: "fadeInUp 0.5s ease-out",
              },
              children: [
                (0, s.jsxs)("div", {
                  className: "flex justify-between",
                  children: [
                    (0, s.jsxs)("div", {
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 11,
                            color: es.sub,
                            letterSpacing: 0.5,
                          },
                          children: "ISSUED",
                        }),
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 15,
                            fontWeight: 700,
                            color: es.ink,
                            paddingTop: 2,
                          },
                          children: "06.05.2026",
                        }),
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 11.5,
                            color: es.sub,
                            paddingTop: 2,
                          },
                          children: "14d net",
                        }),
                      ],
                    }),
                    (0, s.jsxs)("div", {
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 11,
                            color: es.sub,
                            letterSpacing: 0.5,
                          },
                          children: "DUE",
                        }),
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 15,
                            fontWeight: 700,
                            color: es.ink,
                            paddingTop: 2,
                          },
                          children: "20.05.2026",
                        }),
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 11.5,
                            color: es.sub,
                            paddingTop: 2,
                          },
                          children: "Auto-reminder",
                        }),
                      ],
                    }),
                  ],
                }),
                (0, s.jsxs)("div", {
                  className: "flex justify-between pt-6 pb-2",
                  style: { borderBottom: "1px solid ".concat(es.line) },
                  children: [
                    (0, s.jsx)("span", {
                      style: {
                        fontSize: 10.5,
                        color: es.sub,
                        letterSpacing: 0.5,
                      },
                      children: "DESCRIPTION",
                    }),
                    (0, s.jsxs)("div", {
                      className: "flex gap-6",
                      children: [
                        (0, s.jsx)("span", {
                          style: { fontSize: 10.5, color: es.sub },
                          children: "HRS",
                        }),
                        (0, s.jsx)("span", {
                          style: { fontSize: 10.5, color: es.sub },
                          children: "PPU",
                        }),
                        (0, s.jsx)("span", {
                          style: { fontSize: 10.5, color: es.sub },
                          children: "AMOUNT",
                        }),
                      ],
                    }),
                  ],
                }),
                [
                  { d: "Discovery", h: 12, ppu: 180, amt: "2,160" },
                  { d: "Identity", h: 36, ppu: 190, amt: "6,840" },
                  { d: "Guidelines", h: 10, ppu: 180, amt: "2,000" },
                ].map((e, t) =>
                  (0, s.jsxs)(
                    "div",
                    {
                      className: "flex justify-between py-3",
                      style: {
                        borderBottom: "1px solid ".concat(es.line),
                        animation: "fadeInUp 0.4s ease-out ".concat(
                          0.1 + 0.08 * t,
                          "s both",
                        ),
                      },
                      children: [
                        (0, s.jsx)("span", {
                          style: {
                            fontSize: 14.5,
                            fontWeight: 600,
                            color: es.ink,
                          },
                          children: e.d,
                        }),
                        (0, s.jsxs)("div", {
                          className: "flex gap-6",
                          style: { fontSize: 14.5, color: es.ink },
                          children: [
                            (0, s.jsx)("span", {
                              style: { width: 16 },
                              children: e.h,
                            }),
                            (0, s.jsxs)("span", {
                              style: { width: 40 },
                              children: ["$", e.ppu],
                            }),
                            (0, s.jsxs)("span", {
                              style: { fontWeight: 700 },
                              children: ["$", e.amt],
                            }),
                          ],
                        }),
                      ],
                    },
                    e.d,
                  ),
                ),
                (0, s.jsxs)("div", {
                  className: "flex justify-between pt-4",
                  children: [
                    (0, s.jsx)("span", {
                      style: {
                        fontSize: 12.5,
                        color: es.sub,
                        letterSpacing: 0.5,
                      },
                      children: "SUBTOTAL",
                    }),
                    (0, s.jsx)("span", {
                      style: { fontSize: 14.5, fontWeight: 700, color: es.ink },
                      children: "$11,000",
                    }),
                  ],
                }),
                (0, s.jsxs)("div", {
                  className: "flex justify-between pt-2",
                  children: [
                    (0, s.jsx)("span", {
                      style: {
                        fontSize: 12.5,
                        color: es.sub,
                        letterSpacing: 0.5,
                      },
                      children: "VAT 21%",
                    }),
                    (0, s.jsx)("span", {
                      style: { fontSize: 14.5, fontWeight: 700, color: es.ink },
                      children: "$2,310",
                    }),
                  ],
                }),
              ],
            }),
            (0, s.jsxs)(er, {
              onPress: () => d(!a),
              style: {
                padding: "16px 20px 24px",
                background: "#fff",
                borderRadius: a ? "28px 28px 0 0" : 0,
                boxShadow: "0 -20px 40px -20px rgba(0,0,0,0.2)",
                animation: "slideUp 0.4s ease-out",
              },
              children: [
                (0, s.jsx)("div", {
                  style: {
                    width: 40,
                    height: 4,
                    borderRadius: 999,
                    background: es.line,
                    margin: "0 auto",
                  },
                }),
                (0, s.jsxs)("div", {
                  className: "flex items-center justify-between pt-4",
                  children: [
                    (0, s.jsxs)("div", {
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 19,
                            fontWeight: 700,
                            color: es.ink,
                          },
                          children: "Invoice",
                        }),
                        (0, s.jsx)("div", {
                          style: { fontSize: 13, color: es.sub, paddingTop: 1 },
                          children: "IN-001",
                        }),
                      ],
                    }),
                    (0, s.jsxs)("div", {
                      className: "flex items-center gap-1.5 px-3 py-1.5",
                      style: {
                        background: r ? "#E8F5E9" : "#FFF1DB",
                        borderRadius: 999,
                      },
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            width: 7,
                            height: 7,
                            borderRadius: 999,
                            background: r ? es.green : es.orange,
                          },
                        }),
                        (0, s.jsx)("span", {
                          style: {
                            fontSize: 12.5,
                            fontWeight: 700,
                            color: r ? es.green : "#B4700A",
                          },
                          children: r ? "Paid" : "Pending",
                        }),
                      ],
                    }),
                  ],
                }),
                (0, s.jsxs)("div", {
                  className: "flex items-center justify-between pt-5",
                  children: [
                    (0, s.jsxs)("div", {
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 10.5,
                            color: es.sub,
                            letterSpacing: 0.5,
                          },
                          children: "FROM",
                        }),
                        (0, s.jsxs)("div", {
                          className:
                            "flex items-center gap-2 mt-1.5 pl-1.5 pr-3 py-1.5",
                          style: { background: es.chip, borderRadius: 999 },
                          children: [
                            (0, s.jsx)("div", {
                              style: {
                                width: 20,
                                height: 20,
                                borderRadius: 999,
                                background: "#FF7A45",
                              },
                            }),
                            (0, s.jsx)("span", {
                              style: {
                                fontSize: 12.5,
                                fontWeight: 600,
                                color: es.ink,
                              },
                              children: "Studio Sphere BV",
                            }),
                          ],
                        }),
                      ],
                    }),
                    (0, s.jsx)(er, {
                      onPress: () => t("Swap parties"),
                      style: {
                        width: 28,
                        height: 28,
                        borderRadius: 999,
                        background: es.chip,
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "center",
                      },
                      children: (0, s.jsx)(V.Z, { size: 13, color: es.sub }),
                    }),
                    (0, s.jsxs)("div", {
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 10.5,
                            color: es.sub,
                            letterSpacing: 0.5,
                            textAlign: "right",
                          },
                          children: "FOR",
                        }),
                        (0, s.jsxs)("div", {
                          className:
                            "flex items-center gap-2 mt-1.5 pl-1.5 pr-3 py-1.5",
                          style: { background: es.chip, borderRadius: 999 },
                          children: [
                            (0, s.jsx)("div", {
                              style: {
                                width: 20,
                                height: 20,
                                borderRadius: 999,
                                background: es.ink,
                              },
                            }),
                            (0, s.jsx)("span", {
                              style: {
                                fontSize: 12.5,
                                fontWeight: 600,
                                color: es.ink,
                              },
                              children: "Dip Inc.",
                            }),
                          ],
                        }),
                      ],
                    }),
                  ],
                }),
                (0, s.jsxs)("div", {
                  className: "flex items-end justify-between pt-6",
                  style: { borderTop: "1px solid ".concat(es.line) },
                  children: [
                    (0, s.jsx)("div", {
                      style: { paddingTop: 14 },
                      children: (0, s.jsxs)("span", {
                        style: {
                          fontSize: 30,
                          fontWeight: 700,
                          color: r ? es.green : es.ink,
                        },
                        children: [
                          (0, s.jsx)("span", {
                            style: { fontSize: 18, verticalAlign: "top" },
                            children: "$",
                          }),
                          "13,310",
                          (0, s.jsx)("span", {
                            style: { color: es.faint },
                            children: ".00",
                          }),
                        ],
                      }),
                    }),
                    (0, s.jsxs)("div", {
                      style: { textAlign: "right", paddingTop: 14 },
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 10.5,
                            color: es.sub,
                            letterSpacing: 0.5,
                          },
                          children: "DUE",
                        }),
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 14,
                            fontWeight: 700,
                            color: es.ink,
                          },
                          children: "20 May",
                        }),
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 11.5,
                            fontWeight: 600,
                            color: r ? es.green : es.orange,
                          },
                          children: r ? "Completed" : "in 14 days",
                        }),
                      ],
                    }),
                  ],
                }),
                (0, s.jsxs)("div", {
                  className: "flex items-center gap-3 pt-5",
                  style: { animation: "fadeInUp 0.4s ease-out 0.3s both" },
                  children: [
                    (0, s.jsxs)(er, {
                      onPress: r
                        ? () => t("Already paid!")
                        : () => {
                            i(
                              "Confirm Payment",
                              (0, s.jsxs)("div", {
                                children: [
                                  (0, s.jsxs)("div", {
                                    style: {
                                      textAlign: "center",
                                      padding: "10px 0",
                                    },
                                    children: [
                                      (0, s.jsx)("div", {
                                        style: {
                                          width: 60,
                                          height: 60,
                                          borderRadius: 999,
                                          background: "#E8F5E9",
                                          margin: "0 auto",
                                          display: "flex",
                                          alignItems: "center",
                                          justifyContent: "center",
                                        },
                                        children: (0, s.jsx)(X.Z, {
                                          size: 28,
                                          color: es.green,
                                        }),
                                      }),
                                      (0, s.jsx)("div", {
                                        style: {
                                          fontSize: 28,
                                          fontWeight: 700,
                                          color: es.ink,
                                          marginTop: 12,
                                        },
                                        children: "$13,310.00",
                                      }),
                                      (0, s.jsx)("div", {
                                        style: {
                                          fontSize: 13,
                                          color: es.sub,
                                          marginTop: 4,
                                        },
                                        children: "Studio Sphere BV → Dip Inc.",
                                      }),
                                    ],
                                  }),
                                  (0, s.jsxs)(er, {
                                    onPress: () => {
                                      l(!0), h(!1), t("Payment approved! ✓");
                                    },
                                    style: {
                                      width: "100%",
                                      padding: "14px 0",
                                      borderRadius: 999,
                                      background: es.green,
                                      display: "flex",
                                      alignItems: "center",
                                      justifyContent: "center",
                                      gap: 8,
                                    },
                                    children: [
                                      (0, s.jsx)(U.Z, {
                                        size: 16,
                                        color: "#fff",
                                        strokeWidth: 3,
                                      }),
                                      (0, s.jsx)("span", {
                                        style: {
                                          fontSize: 15,
                                          fontWeight: 700,
                                          color: "#fff",
                                        },
                                        children: "Confirm & Pay",
                                      }),
                                    ],
                                  }),
                                ],
                              }),
                            );
                          },
                      style: {
                        flex: 1,
                        padding: "16px 0",
                        borderRadius: 999,
                        background: r ? es.green : es.ink,
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "center",
                        gap: 8,
                        transition: "background 0.3s ease",
                      },
                      children: [
                        r
                          ? (0, s.jsx)(U.Z, {
                              size: 15,
                              color: "#fff",
                              strokeWidth: 3,
                            })
                          : (0, s.jsx)(X.Z, {
                              size: 15,
                              color: "#fff",
                              strokeWidth: 3,
                            }),
                        (0, s.jsx)("span", {
                          style: {
                            fontSize: 15,
                            fontWeight: 700,
                            color: "#fff",
                          },
                          children: r ? "Paid ✓" : "Approve & Pay",
                        }),
                      ],
                    }),
                    (0, s.jsx)(er, {
                      onPress: () => h(!0),
                      style: {
                        width: 52,
                        height: 52,
                        borderRadius: 999,
                        background: es.chip,
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "center",
                      },
                      children: (0, s.jsx)(_.Z, { size: 18, color: es.ink }),
                    }),
                  ],
                }),
                (0, s.jsxs)(er, {
                  onPress: () => o("scanReceipts"),
                  style: {
                    width: "100%",
                    padding: "14px 0",
                    borderRadius: 999,
                    border: "1.5px solid ".concat(es.line),
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    gap: 8,
                    marginTop: 16,
                    marginBottom: 4,
                  },
                  children: [
                    (0, s.jsx)(q.Z, { size: 16, color: es.sub }),
                    (0, s.jsx)("span", {
                      style: { fontSize: 14, fontWeight: 600, color: es.sub },
                      children: "Scan Receipt",
                    }),
                  ],
                }),
              ],
            }),
            c &&
              (0, s.jsx)(eo, {
                title: "Invoice Options",
                onClose: () => h(!1),
                children: [
                  {
                    icon: (0, s.jsx)(C.Z, { size: 16 }),
                    label: "Copy Invoice",
                    action: () => t("Invoice copied!"),
                  },
                  {
                    icon: (0, s.jsx)(F.Z, { size: 16 }),
                    label: "Share Invoice",
                    action: () => t("Invoice shared!"),
                  },
                  {
                    icon: (0, s.jsx)(J.Z, { size: 16 }),
                    label: "Download PDF",
                    action: () => t("Downloading PDF..."),
                  },
                  {
                    icon: (0, s.jsx)(Q.Z, { size: 16 }),
                    label: "Delete Invoice",
                    action: () => {
                      t("Invoice deleted"), h(!1);
                    },
                  },
                ].map((e) =>
                  (0, s.jsxs)(
                    er,
                    {
                      onPress: () => {
                        e.action(), h(!1);
                      },
                      style: {
                        display: "flex",
                        alignItems: "center",
                        gap: 12,
                        padding: "14px 0",
                        borderBottom: "1px solid ".concat(es.line),
                      },
                      children: [
                        (0, s.jsx)("div", {
                          style: { color: es.sub },
                          children: e.icon,
                        }),
                        (0, s.jsx)("span", {
                          style: {
                            fontSize: 15,
                            fontWeight: 500,
                            color:
                              "Delete Invoice" === e.label ? "#EF4444" : es.ink,
                          },
                          children: e.label,
                        }),
                      ],
                    },
                    e.label,
                  ),
                ),
              }),
          ],
        });
      }
      function ef(e) {
        let { showToast: t, showModal: i, onNavigate: r } = e,
          [a, d] = (0, n.useState)(!1),
          [c, h] = (0, n.useState)(0),
          [f, x] = (0, n.useState)(null),
          [p, g] = (0, n.useState)(!1),
          [u, m] = (0, n.useState)("Groceries"),
          [y, j] = (0, n.useState)("Monthly groceries"),
          [b, v] = (0, n.useState)(!1),
          [S, k] = (0, n.useState)(!1),
          [z, w] = (0, n.useState)(0),
          [C, F] = (0, n.useState)(!1),
          [R, I] = (0, n.useState)(null),
          W = (e) => {
            k(!1), w(0), F(!1), g(!0), setTimeout(() => k(!0), 400);
            let t = (null == e ? void 0 : e.items) || [];
            t.forEach((e, t) => {
              setTimeout(() => w(t + 1), 600 + 120 * t);
            }),
              setTimeout(() => F(!0), 600 + 120 * t.length + 200);
          },
          E = async () => {
            if (l.dV.isNativePlatform())
              try {
                let e = await o.V1.getPhoto({
                  quality: 90,
                  allowEditing: !1,
                  resultType: o.dk.Base64,
                  source: o.oK.Camera,
                  width: 1200,
                  height: 1600,
                });
                I("data:image/jpeg;base64," + e.base64String);
              } catch (e) {
                console.log(
                  "Camera cancelled or unavailable:",
                  null == e ? void 0 : e.message,
                ),
                  I(null);
              }
            else I(null);
            x(null), g(!1), d(!0), h(0);
            let e = 0,
              t = setInterval(() => {
                if ((h((e += 2)), e >= 100)) {
                  clearInterval(t), d(!1);
                  let e = {
                    store: "Walmart Supercenter",
                    letter: "W",
                    color: "#0071DC",
                    date: new Date().toLocaleDateString("en-US", {
                      day: "2-digit",
                      month: "short",
                      year: "numeric",
                    }),
                    total: "1,288.60",
                    amount: "$1,288.60",
                    items: [
                      { name: "Electronics", qty: 2, price: "$599.98" },
                      { name: "Groceries", qty: 12, price: "$246.32" },
                      { name: "Household", qty: 5, price: "$89.45" },
                      { name: "Clothing", qty: 3, price: "$112.85" },
                      { name: "Tax", qty: 1, price: "$240.00" },
                    ],
                  };
                  x(e),
                    m("Groceries"),
                    j("Monthly groceries"),
                    setTimeout(() => W(e), 200);
                }
              }, 40);
          },
          B = (e) => {
            let t = {
              ...e,
              store: e.store,
              letter: e.letter,
              color: e.color,
              date: e.date,
            };
            x(t),
              m(e.folder || "Groceries"),
              j(e.note || ""),
              g(!1),
              setTimeout(() => W(t), 100);
          };
        return f
          ? (0, s.jsxs)("div", {
              className: "flex flex-col h-full",
              style: {
                background: "#EDECE9",
                overflowY: "auto",
                position: "relative",
              },
              children: [
                (0, s.jsx)("div", {
                  onClick: () => {
                    g(!1), setTimeout(() => x(null), 400);
                  },
                  style: {
                    position: "absolute",
                    inset: 0,
                    zIndex: 1,
                    background: "rgba(0,0,0,0.45)",
                    backdropFilter: "blur(4px)",
                    animation: p
                      ? "fadeIn 0.3s ease-out"
                      : "fadeOut 0.3s ease-out forwards",
                  },
                }),
                (0, s.jsx)("div", {
                  style: {
                    position: "absolute",
                    bottom: 0,
                    left: 0,
                    right: 0,
                    zIndex: 2,
                    maxHeight: "88%",
                    animation: p
                      ? "receiptSlideUp 0.6s cubic-bezier(0.34, 1.56, 0.64, 1) forwards"
                      : "receiptSlideDown 0.35s ease-in forwards",
                  },
                  children: (0, s.jsxs)("div", {
                    style: {
                      background: "#fff",
                      borderTopLeftRadius: 28,
                      borderTopRightRadius: 28,
                      overflow: "hidden",
                      boxShadow: "0 -8px 40px rgba(0,0,0,0.18)",
                    },
                    children: [
                      (0, s.jsx)("div", {
                        style: {
                          display: "flex",
                          justifyContent: "center",
                          padding: "12px 0 4px",
                        },
                        children: (0, s.jsx)("div", {
                          style: {
                            width: 40,
                            height: 4,
                            borderRadius: 4,
                            background: es.line,
                          },
                        }),
                      }),
                      (0, s.jsxs)("div", {
                        style: {
                          overflowY: "auto",
                          maxHeight: "calc(88vh - 16px)",
                          paddingBottom: 20,
                        },
                        children: [
                          (0, s.jsxs)("div", {
                            className: "flex items-center gap-3 px-5 pb-2",
                            children: [
                              (0, s.jsx)(er, {
                                onPress: () => {
                                  g(!1), setTimeout(() => x(null), 400);
                                },
                                style: {
                                  width: 36,
                                  height: 36,
                                  borderRadius: 999,
                                  background: es.chip,
                                  display: "flex",
                                  alignItems: "center",
                                  justifyContent: "center",
                                  animation: "fadeInUp 0.3s ease-out",
                                },
                                children: (0, s.jsx)(G.Z, {
                                  size: 16,
                                  color: es.ink,
                                }),
                              }),
                              (0, s.jsx)("span", {
                                style: {
                                  fontSize: 17,
                                  fontWeight: 700,
                                  color: es.ink,
                                },
                                children: "Scan result",
                              }),
                            ],
                          }),
                          (0, s.jsxs)("div", {
                            className: "flex flex-col items-center pt-3 pb-4",
                            style: {
                              animation:
                                "receiptStoreBounce 0.5s cubic-bezier(0.34, 1.56, 0.64, 1) 0.2s both",
                            },
                            children: [
                              (0, s.jsxs)("div", {
                                style: { position: "relative" },
                                children: [
                                  (0, s.jsx)("div", {
                                    style: {
                                      width: 64,
                                      height: 64,
                                      borderRadius: 20,
                                      background: f.color || "#0071DC",
                                      display: "flex",
                                      alignItems: "center",
                                      justifyContent: "center",
                                      boxShadow: "0 8px 24px ".concat(
                                        f.color || "#0071DC",
                                        "40",
                                      ),
                                    },
                                    children: (0, s.jsx)("span", {
                                      style: {
                                        fontSize: 26,
                                        fontWeight: 800,
                                        color: "#fff",
                                      },
                                      children: f.letter,
                                    }),
                                  }),
                                  (0, s.jsx)("div", {
                                    style: {
                                      position: "absolute",
                                      bottom: -4,
                                      right: -4,
                                      width: 26,
                                      height: 26,
                                      borderRadius: 999,
                                      background: es.green,
                                      display: "flex",
                                      alignItems: "center",
                                      justifyContent: "center",
                                      boxShadow:
                                        "0 2px 8px rgba(34,197,94,0.4)",
                                      animation: S
                                        ? "receiptCheckPop 0.4s cubic-bezier(0.34, 1.56, 0.64, 1) forwards"
                                        : "none",
                                      transform: S ? "scale(1)" : "scale(0)",
                                    },
                                    children: (0, s.jsx)("svg", {
                                      width: "14",
                                      height: "14",
                                      viewBox: "0 0 24 24",
                                      fill: "none",
                                      stroke: "#fff",
                                      strokeWidth: "3",
                                      strokeLinecap: "round",
                                      strokeLinejoin: "round",
                                      children: (0, s.jsx)("polyline", {
                                        points: "20 6 9 17 4 12",
                                        style: {
                                          strokeDasharray: 24,
                                          strokeDashoffset: S ? 0 : 24,
                                          transition:
                                            "stroke-dashoffset 0.4s ease-out 0.3s",
                                        },
                                      }),
                                    }),
                                  }),
                                ],
                              }),
                              (0, s.jsx)("div", {
                                style: {
                                  fontSize: 16,
                                  fontWeight: 700,
                                  color: es.ink,
                                  marginTop: 10,
                                },
                                children: f.store || f.name,
                              }),
                              (0, s.jsx)("div", {
                                style: {
                                  fontSize: 12,
                                  color: es.sub,
                                  marginTop: 2,
                                },
                                children: f.date,
                              }),
                            ],
                          }),
                          (0, s.jsxs)("div", {
                            className: "mx-5",
                            style: { position: "relative" },
                            children: [
                              (0, s.jsxs)("div", {
                                style: {
                                  background: "#FAFAF8",
                                  borderRadius: "16px 16px 0 0",
                                  padding: "20px 18px 16px",
                                  border: "1px solid #EDECE9",
                                  borderBottom: "none",
                                },
                                children: [
                                  (0, s.jsx)("div", {
                                    style: {
                                      overflow: "hidden",
                                      marginBottom: 12,
                                    },
                                    children: (0, s.jsx)("div", {
                                      style: {
                                        borderTop: "2px dashed #D9D8D4",
                                        animation:
                                          "dashDraw 0.8s ease-out 0.4s both",
                                      },
                                    }),
                                  }),
                                  (f.items || []).map((e, t) =>
                                    (0, s.jsxs)(
                                      "div",
                                      {
                                        className:
                                          "flex justify-between items-center",
                                        style: {
                                          padding: "8px 0",
                                          opacity: t < z ? 1 : 0,
                                          transform:
                                            t < z
                                              ? "translateX(0)"
                                              : "translateX(-20px)",
                                          transition:
                                            "all 0.35s cubic-bezier(0.34, 1.56, 0.64, 1)",
                                        },
                                        children: [
                                          (0, s.jsxs)("div", {
                                            className:
                                              "flex items-center gap-2",
                                            children: [
                                              (0, s.jsx)("div", {
                                                style: {
                                                  width: 6,
                                                  height: 6,
                                                  borderRadius: 999,
                                                  background:
                                                    t < z
                                                      ? es.green
                                                      : "transparent",
                                                  transition:
                                                    "background 0.3s ease",
                                                },
                                              }),
                                              (0, s.jsx)("span", {
                                                style: {
                                                  fontSize: 14,
                                                  color: es.ink,
                                                },
                                                children: e.name,
                                              }),
                                              e.qty > 1 &&
                                                (0, s.jsxs)("span", {
                                                  style: {
                                                    fontSize: 11,
                                                    color: es.sub,
                                                    background: es.chip,
                                                    padding: "1px 6px",
                                                    borderRadius: 6,
                                                  },
                                                  children: ["\xd7", e.qty],
                                                }),
                                            ],
                                          }),
                                          (0, s.jsx)("span", {
                                            style: {
                                              fontSize: 14,
                                              fontWeight: 600,
                                              color: es.ink,
                                            },
                                            children: e.price,
                                          }),
                                        ],
                                      },
                                      t,
                                    ),
                                  ),
                                  (0, s.jsx)("div", {
                                    style: {
                                      overflow: "hidden",
                                      margin: "8px 0",
                                    },
                                    children: (0, s.jsx)("div", {
                                      style: {
                                        borderTop: "2px dashed #D9D8D4",
                                        animation: C
                                          ? "dashDraw 0.6s ease-out forwards"
                                          : "none",
                                      },
                                    }),
                                  }),
                                  (0, s.jsxs)("div", {
                                    className:
                                      "flex justify-between items-center",
                                    style: {
                                      padding: "4px 0 2px",
                                      opacity: C ? 1 : 0,
                                      transform: C
                                        ? "translateY(0) scale(1)"
                                        : "translateY(10px) scale(0.95)",
                                      transition:
                                        "all 0.4s cubic-bezier(0.34, 1.56, 0.64, 1)",
                                    },
                                    children: [
                                      (0, s.jsx)("span", {
                                        style: {
                                          fontSize: 15,
                                          fontWeight: 700,
                                          color: es.ink,
                                        },
                                        children: "Total",
                                      }),
                                      (0, s.jsxs)("span", {
                                        style: {
                                          fontSize: 20,
                                          fontWeight: 800,
                                          color: es.ink,
                                        },
                                        children: ["$", f.total],
                                      }),
                                    ],
                                  }),
                                ],
                              }),
                              (0, s.jsx)("div", {
                                style: {
                                  height: 16,
                                  overflow: "hidden",
                                  marginTop: -1,
                                },
                                children: (0, s.jsx)("svg", {
                                  width: "100%",
                                  height: "16",
                                  viewBox: "0 0 400 16",
                                  preserveAspectRatio: "none",
                                  children: (0, s.jsx)("path", {
                                    d: "M0,0 L10,8 L20,0 L30,8 L40,0 L50,8 L60,0 L70,8 L80,0 L90,8 L100,0 L110,8 L120,0 L130,8 L140,0 L150,8 L160,0 L170,8 L180,0 L190,8 L200,0 L210,8 L220,0 L230,8 L240,0 L250,8 L260,0 L270,8 L280,0 L290,8 L300,0 L310,8 L320,0 L330,8 L340,0 L350,8 L360,0 L370,8 L380,0 L390,8 L400,0 L400,16 L0,16 Z",
                                    fill: "#FAFAF8",
                                  }),
                                }),
                              }),
                            ],
                          }),
                          (0, s.jsxs)("div", {
                            className: "px-5 mt-4",
                            style: {
                              opacity: C ? 1 : 0,
                              transform: C
                                ? "translateY(0)"
                                : "translateY(16px)",
                              transition: "all 0.4s ease-out 0.1s",
                            },
                            children: [
                              (0, s.jsx)("span", {
                                style: {
                                  fontSize: 12,
                                  fontWeight: 600,
                                  color: es.sub,
                                  letterSpacing: 0.3,
                                },
                                children: "Select folder",
                              }),
                              (0, s.jsx)("div", {
                                className: "flex flex-wrap gap-2 mt-2.5",
                                children: [
                                  { id: "Inbox", icon: "\uD83D\uDCE5" },
                                  { id: "Home & Living", icon: "\uD83C\uDFE0" },
                                  { id: "Groceries", icon: "\uD83D\uDED2" },
                                  { id: "Travel", icon: "✈️" },
                                  { id: "Other", icon: "\uD83D\uDCC1" },
                                ].map((e) =>
                                  (0, s.jsxs)(
                                    er,
                                    {
                                      onPress: () => m(e.id),
                                      style: {
                                        display: "flex",
                                        alignItems: "center",
                                        gap: 5,
                                        padding: "7px 13px",
                                        borderRadius: 999,
                                        background:
                                          u === e.id ? es.green : es.chip,
                                        border:
                                          u === e.id
                                            ? "none"
                                            : "1.5px solid ".concat(es.line),
                                        transition:
                                          "all 0.25s cubic-bezier(0.34, 1.56, 0.64, 1)",
                                        transform:
                                          u === e.id
                                            ? "scale(1.03)"
                                            : "scale(1)",
                                      },
                                      children: [
                                        (0, s.jsx)("span", {
                                          style: { fontSize: 13 },
                                          children: e.icon,
                                        }),
                                        (0, s.jsx)("span", {
                                          style: {
                                            fontSize: 12,
                                            fontWeight: 600,
                                            color: u === e.id ? "#fff" : es.ink,
                                          },
                                          children: e.id,
                                        }),
                                        u === e.id &&
                                          (0, s.jsx)(U.Z, {
                                            size: 12,
                                            color: "#fff",
                                            strokeWidth: 3,
                                            style: {
                                              animation:
                                                "receiptCheckPop 0.3s cubic-bezier(0.34, 1.56, 0.64, 1)",
                                            },
                                          }),
                                      ],
                                    },
                                    e.id,
                                  ),
                                ),
                              }),
                            ],
                          }),
                          (0, s.jsxs)("div", {
                            className: "px-5 mt-3",
                            style: {
                              opacity: C ? 1 : 0,
                              transform: C
                                ? "translateY(0)"
                                : "translateY(16px)",
                              transition: "all 0.4s ease-out 0.2s",
                            },
                            children: [
                              (0, s.jsx)("span", {
                                style: {
                                  fontSize: 12,
                                  fontWeight: 600,
                                  color: es.sub,
                                  letterSpacing: 0.3,
                                },
                                children: "Note",
                              }),
                              (0, s.jsx)("div", {
                                style: { marginTop: 6 },
                                children: (0, s.jsx)("input", {
                                  type: "text",
                                  value: y,
                                  onChange: (e) => j(e.target.value),
                                  onFocus: () => v(!0),
                                  onBlur: () => v(!1),
                                  placeholder: "Add a note...",
                                  style: {
                                    width: "100%",
                                    padding: "10px 14px",
                                    borderRadius: 12,
                                    border: "1.5px solid ".concat(
                                      b ? es.green : es.line,
                                    ),
                                    fontSize: 14,
                                    fontWeight: 500,
                                    color: es.ink,
                                    background: es.chip,
                                    outline: "none",
                                    transition: "border-color 0.2s ease",
                                    fontFamily: "inherit",
                                  },
                                }),
                              }),
                            ],
                          }),
                          (0, s.jsx)("div", {
                            className: "px-5 mt-4 pb-2",
                            style: {
                              opacity: C ? 1 : 0,
                              transform: C
                                ? "translateY(0)"
                                : "translateY(16px)",
                              transition: "all 0.4s ease-out 0.3s",
                            },
                            children: (0, s.jsxs)(er, {
                              onPress: () => {
                                f &&
                                  (t(
                                    "Added "
                                      .concat(f.amount, " to ")
                                      .concat(u, " ✓"),
                                  ),
                                  setTimeout(() => {
                                    g(!1),
                                      setTimeout(() => {
                                        x(null), r("dashboard");
                                      }, 400);
                                  }, 300));
                              },
                              style: {
                                width: "100%",
                                padding: "15px 0",
                                borderRadius: 999,
                                background: es.green,
                                display: "flex",
                                alignItems: "center",
                                justifyContent: "center",
                                gap: 8,
                                transition: "all 0.2s ease",
                                boxShadow: "0 4px 16px rgba(34,197,94,0.3)",
                              },
                              children: [
                                (0, s.jsx)(U.Z, {
                                  size: 16,
                                  color: "#fff",
                                  strokeWidth: 3,
                                }),
                                (0, s.jsx)("span", {
                                  style: {
                                    fontSize: 15,
                                    fontWeight: 700,
                                    color: "#fff",
                                  },
                                  children: "Add to your transactions",
                                }),
                              ],
                            }),
                          }),
                        ],
                      }),
                    ],
                  }),
                }),
                (0, s.jsx)("div", { style: { flex: 1 } }),
              ],
            })
          : (0, s.jsxs)("div", {
              className: "flex flex-col h-full",
              style: { background: "#EDECE9", overflowY: "auto" },
              children: [
                (0, s.jsxs)("div", {
                  className: "flex items-center gap-3 px-5 pt-4 pb-1",
                  children: [
                    (0, s.jsx)(er, {
                      onPress: () => r("invoice"),
                      style: {
                        width: 40,
                        height: 40,
                        borderRadius: 999,
                        background: "#fff",
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "center",
                        animation: "fadeInUp 0.4s ease-out",
                      },
                      children: (0, s.jsx)(G.Z, { size: 16, color: es.ink }),
                    }),
                    (0, s.jsx)("span", {
                      style: {
                        fontSize: 18,
                        fontWeight: 700,
                        color: es.ink,
                        animation: "fadeInUp 0.4s ease-out 0.05s both",
                      },
                      children: "Scan receipts",
                    }),
                  ],
                }),
                (0, s.jsxs)("div", {
                  className: "mx-5 mt-2",
                  style: { animation: "fadeInUp 0.5s ease-out 0.1s both" },
                  children: [
                    (0, s.jsxs)("div", {
                      style: {
                        position: "relative",
                        background: "#2A2A2E",
                        borderRadius: 24,
                        height: 240,
                        overflow: "hidden",
                      },
                      children: [
                        R &&
                          (0, s.jsx)("img", {
                            src: R,
                            alt: "Captured receipt",
                            style: {
                              position: "absolute",
                              inset: 0,
                              width: "100%",
                              height: "100%",
                              objectFit: "cover",
                              zIndex: 2,
                            },
                          }),
                        (0, s.jsx)("div", {
                          style: {
                            position: "absolute",
                            inset: 0,
                            opacity: 0.12,
                            backgroundImage:
                              "radial-gradient(circle, #fff 1px, transparent 1px)",
                            backgroundSize: "18px 18px",
                          },
                        }),
                        (0, s.jsxs)("div", {
                          style: {
                            position: "absolute",
                            top: 40,
                            left: 30,
                            right: 30,
                            bottom: 40,
                          },
                          children: [
                            (0, s.jsx)("div", {
                              style: {
                                position: "absolute",
                                top: 0,
                                left: 0,
                                width: 28,
                                height: 28,
                                borderTop: "3px solid #22C55E",
                                borderLeft: "3px solid #22C55E",
                                borderTopLeftRadius: 8,
                              },
                            }),
                            (0, s.jsx)("div", {
                              style: {
                                position: "absolute",
                                top: 0,
                                right: 0,
                                width: 28,
                                height: 28,
                                borderTop: "3px solid #22C55E",
                                borderRight: "3px solid #22C55E",
                                borderTopRightRadius: 8,
                              },
                            }),
                            (0, s.jsx)("div", {
                              style: {
                                position: "absolute",
                                bottom: 0,
                                left: 0,
                                width: 28,
                                height: 28,
                                borderBottom: "3px solid #22C55E",
                                borderLeft: "3px solid #22C55E",
                                borderBottomLeftRadius: 8,
                              },
                            }),
                            (0, s.jsx)("div", {
                              style: {
                                position: "absolute",
                                bottom: 0,
                                right: 0,
                                width: 28,
                                height: 28,
                                borderBottom: "3px solid #22C55E",
                                borderRight: "3px solid #22C55E",
                                borderBottomRightRadius: 8,
                              },
                            }),
                            a &&
                              (0, s.jsx)("div", {
                                style: {
                                  position: "absolute",
                                  left: 0,
                                  right: 0,
                                  height: 2,
                                  background:
                                    "linear-gradient(90deg, transparent, #22C55E, transparent)",
                                  animation:
                                    "scanLine 1.5s ease-in-out infinite",
                                  boxShadow: "0 0 12px 3px rgba(34,197,94,0.4)",
                                },
                              }),
                          ],
                        }),
                        a &&
                          (0, s.jsxs)("div", {
                            style: {
                              position: "absolute",
                              bottom: 16,
                              left: "50%",
                              transform: "translateX(-50%)",
                              display: "flex",
                              alignItems: "center",
                              gap: 8,
                              background: "rgba(0,0,0,0.6)",
                              padding: "6px 14px",
                              borderRadius: 999,
                            },
                            children: [
                              (0, s.jsx)("div", {
                                style: {
                                  width: 16,
                                  height: 16,
                                  borderRadius: 999,
                                  border: "2px solid rgba(255,255,255,0.3)",
                                  borderTop: "2px solid #22C55E",
                                  animation: "spin 0.8s linear infinite",
                                },
                              }),
                              (0, s.jsxs)("span", {
                                style: {
                                  fontSize: 12,
                                  fontWeight: 600,
                                  color: "#fff",
                                },
                                children: [c, "%"],
                              }),
                            ],
                          }),
                      ],
                    }),
                    (0, s.jsx)("div", {
                      style: {
                        textAlign: "center",
                        padding: "14px 0 4px",
                        animation: "fadeInUp 0.5s ease-out 0.2s both",
                      },
                      children: (0, s.jsx)("span", {
                        style: {
                          fontSize: 13.5,
                          fontWeight: 500,
                          color: es.sub,
                        },
                        children: "Scan receipts to auto-import transactions",
                      }),
                    }),
                    (0, s.jsxs)(er, {
                      onPress: E,
                      style: {
                        width: "100%",
                        padding: "14px 0",
                        borderRadius: 999,
                        background: a ? es.sub : es.green,
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "center",
                        gap: 8,
                        marginTop: 4,
                        transition: "background 0.3s ease",
                      },
                      children: [
                        (0, s.jsx)(q.Z, { size: 18, color: "#fff" }),
                        (0, s.jsx)("span", {
                          style: {
                            fontSize: 15,
                            fontWeight: 700,
                            color: "#fff",
                          },
                          children: a ? "Scanning..." : "Scan Receipt",
                        }),
                      ],
                    }),
                  ],
                }),
                (0, s.jsxs)("div", {
                  className: "px-5 mt-5 pb-6",
                  style: { animation: "fadeInUp 0.5s ease-out 0.3s both" },
                  children: [
                    (0, s.jsx)("div", {
                      style: {
                        fontSize: 13,
                        fontWeight: 700,
                        color: es.sub,
                        letterSpacing: 0.5,
                        marginBottom: 12,
                      },
                      children: "RECENT SCANS",
                    }),
                    (0, s.jsx)("div", {
                      style: {
                        display: "grid",
                        gridTemplateColumns: "1fr 1fr",
                        gap: 10,
                      },
                      children: [
                        {
                          store: "Target",
                          letter: "T",
                          color: "#CC0000",
                          date: "16 Mar",
                          amount: "$486.91",
                          total: "486.91",
                          note: "Household supplies",
                          folder: "Home & Living",
                          items: [
                            { name: "Paper Towels", qty: 3, price: "$24.99" },
                            { name: "Dish Soap", qty: 2, price: "$8.49" },
                            { name: "Light Bulbs", qty: 4, price: "$15.96" },
                            { name: "Storage Bins", qty: 2, price: "$34.98" },
                            { name: "Cleaning Spray", qty: 3, price: "$12.87" },
                          ],
                        },
                        {
                          store: "Target",
                          letter: "T",
                          color: "#CC0000",
                          date: "10 Mar",
                          amount: "$161.13",
                          total: "161.13",
                          note: "Weekly groceries",
                          folder: "Groceries",
                          items: [
                            { name: "Organic Milk", qty: 2, price: "$7.98" },
                            { name: "Sourdough Bread", qty: 1, price: "$4.49" },
                            { name: "Avocados", qty: 4, price: "$5.96" },
                            { name: "Chicken Breast", qty: 2, price: "$15.98" },
                            { name: "Fresh Berries", qty: 3, price: "$11.97" },
                          ],
                        },
                        {
                          store: "Shell",
                          letter: "S",
                          color: "#FBBC04",
                          date: "6 Feb",
                          amount: "$151.00",
                          total: "151.00",
                          note: "Fuel fill-up",
                          folder: "Travel",
                          items: [
                            { name: "Unleaded 95", qty: 1, price: "$65.00" },
                            { name: "Diesel Premium", qty: 1, price: "$86.00" },
                          ],
                        },
                        {
                          store: "Target",
                          letter: "T",
                          color: "#CC0000",
                          date: "2 Mar",
                          amount: "$164.00",
                          total: "164.00",
                          note: "Clothing",
                          folder: "Other",
                          items: [
                            { name: "Cotton T-Shirt", qty: 3, price: "$44.97" },
                            { name: "Denim Jeans", qty: 1, price: "$39.99" },
                            { name: "Running Shoes", qty: 1, price: "$79.04" },
                          ],
                        },
                        {
                          store: "Shell",
                          letter: "S",
                          color: "#FBBC04",
                          date: "13 Feb",
                          amount: "$70.00",
                          total: "70.00",
                          note: "Gas",
                          folder: "Travel",
                          items: [
                            { name: "Unleaded 95", qty: 1, price: "$70.00" },
                          ],
                        },
                      ].map((e, t) =>
                        (0, s.jsxs)(
                          er,
                          {
                            onPress: () => B(e),
                            style: {
                              background: "#fff",
                              borderRadius: 16,
                              padding: "14px 12px",
                              display: "flex",
                              flexDirection: "column",
                              gap: 8,
                              animation: "fadeInUp 0.4s ease-out ".concat(
                                0.35 + 0.07 * t,
                                "s both",
                              ),
                              transition:
                                "transform 0.2s cubic-bezier(0.34, 1.56, 0.64, 1)",
                            },
                            children: [
                              (0, s.jsxs)("div", {
                                className: "flex items-center justify-between",
                                children: [
                                  (0, s.jsxs)("div", {
                                    className: "flex items-center gap-2",
                                    children: [
                                      (0, s.jsx)("div", {
                                        style: {
                                          width: 32,
                                          height: 32,
                                          borderRadius: 999,
                                          background: e.color,
                                          display: "flex",
                                          alignItems: "center",
                                          justifyContent: "center",
                                        },
                                        children: (0, s.jsx)("span", {
                                          style: {
                                            fontSize: 14,
                                            fontWeight: 700,
                                            color: "#fff",
                                          },
                                          children: e.letter,
                                        }),
                                      }),
                                      (0, s.jsxs)("div", {
                                        children: [
                                          (0, s.jsx)("div", {
                                            style: {
                                              fontSize: 13,
                                              fontWeight: 700,
                                              color: es.ink,
                                              lineHeight: 1.2,
                                            },
                                            children: e.store,
                                          }),
                                          (0, s.jsx)("div", {
                                            style: {
                                              fontSize: 11,
                                              color: es.sub,
                                            },
                                            children: e.date,
                                          }),
                                        ],
                                      }),
                                    ],
                                  }),
                                  (0, s.jsx)("div", {
                                    style: {
                                      width: 20,
                                      height: 20,
                                      borderRadius: 999,
                                      background: "#E8F5E9",
                                      display: "flex",
                                      alignItems: "center",
                                      justifyContent: "center",
                                    },
                                    children: (0, s.jsx)(U.Z, {
                                      size: 11,
                                      color: es.green,
                                      strokeWidth: 3,
                                    }),
                                  }),
                                ],
                              }),
                              (0, s.jsx)("div", {
                                style: {
                                  fontSize: 15,
                                  fontWeight: 700,
                                  color: es.ink,
                                },
                                children: e.amount,
                              }),
                            ],
                          },
                          t,
                        ),
                      ),
                    }),
                  ],
                }),
              ],
            });
      }
      function ex(e) {
        let { showToast: t, onNavigate: i } = e,
          n = [
            { name: "Housing", value: 2100, color: "#FF6B6B" },
            { name: "Food", value: 850, color: "#FF9F0A" },
            { name: "Transport", value: 520, color: "#0A84FF" },
            { name: "Shopping", value: 940, color: "#8B5CF6" },
            { name: "Bills", value: 680, color: "#22C55E" },
            { name: "Other", value: 430, color: "#FF69B4" },
          ];
        return (0, s.jsxs)("div", {
          className: "flex flex-col h-full",
          style: { background: es.bg, overflowY: "auto" },
          children: [
            (0, s.jsxs)("div", {
              className: "flex items-center justify-between px-6 pt-4 pb-2",
              children: [
                (0, s.jsx)(er, {
                  onPress: () => i("dashboard"),
                  style: {
                    width: 40,
                    height: 40,
                    borderRadius: 999,
                    background: "#fff",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                  },
                  children: (0, s.jsx)(G.Z, { size: 16, color: es.ink }),
                }),
                (0, s.jsx)("div", {
                  style: { fontSize: 17, fontWeight: 700, color: es.ink },
                  children: "Analytics",
                }),
                (0, s.jsx)("div", { style: { width: 40 } }),
              ],
            }),
            (0, s.jsx)("div", {
              className: "grid grid-cols-2 gap-3 px-6 pt-2",
              children: [
                {
                  label: "Total Income",
                  amount: "$52,000",
                  change: "+8.2%",
                  up: !0,
                },
                {
                  label: "Total Expenses",
                  amount: "$26,100",
                  change: "+3.1%",
                  up: !1,
                },
                {
                  label: "Savings Rate",
                  amount: "49.8%",
                  change: "+5.2%",
                  up: !0,
                },
                {
                  label: "Avg. Monthly",
                  amount: "$4,350",
                  change: "-2.1%",
                  up: !1,
                },
              ].map((e, t) =>
                (0, s.jsxs)(
                  "div",
                  {
                    style: {
                      background: "#fff",
                      borderRadius: 16,
                      padding: "14px 16px",
                      animation: "fadeInUp 0.4s ease-out ".concat(
                        0.06 * t,
                        "s both",
                      ),
                    },
                    children: [
                      (0, s.jsx)("div", {
                        style: { fontSize: 11, color: es.sub, fontWeight: 500 },
                        children: e.label,
                      }),
                      (0, s.jsx)("div", {
                        style: {
                          fontSize: 20,
                          fontWeight: 700,
                          color: es.ink,
                          marginTop: 4,
                        },
                        children: e.amount,
                      }),
                      (0, s.jsxs)("div", {
                        className: "flex items-center gap-1 mt-1",
                        children: [
                          (0, s.jsx)(N.Z, {
                            size: 12,
                            color: e.up ? es.green : "#FF6B6B",
                          }),
                          (0, s.jsx)("span", {
                            style: {
                              fontSize: 12,
                              fontWeight: 600,
                              color: e.up ? es.green : "#FF6B6B",
                            },
                            children: e.change,
                          }),
                        ],
                      }),
                    ],
                  },
                  e.label,
                ),
              ),
            }),
            (0, s.jsxs)("div", {
              className: "mx-6 mt-4 p-4",
              style: {
                background: "#fff",
                borderRadius: 20,
                animation: "fadeInUp 0.5s ease-out 0.2s both",
              },
              children: [
                (0, s.jsx)("div", {
                  style: {
                    fontSize: 14,
                    fontWeight: 700,
                    color: es.ink,
                    marginBottom: 12,
                  },
                  children: "Income vs Expenses",
                }),
                (0, s.jsx)("div", {
                  style: { height: 200 },
                  children: (0, s.jsx)(a.h, {
                    width: "100%",
                    height: "100%",
                    children: (0, s.jsxs)(y.v, {
                      data: [
                        { month: "Jan", income: 8200, expenses: 4100 },
                        { month: "Feb", income: 8500, expenses: 4300 },
                        { month: "Mar", income: 7800, expenses: 3900 },
                        { month: "Apr", income: 9200, expenses: 4600 },
                        { month: "May", income: 8800, expenses: 4200 },
                        { month: "Jun", income: 9500, expenses: 4500 },
                      ],
                      barGap: 4,
                      children: [
                        (0, s.jsx)(c.q, {
                          strokeDasharray: "3 3",
                          stroke: "#E7E5E1",
                          vertical: !1,
                        }),
                        (0, s.jsx)(h.K, {
                          dataKey: "month",
                          fontSize: 11,
                          tick: { fill: "#9A9A9E" },
                          axisLine: !1,
                          tickLine: !1,
                        }),
                        (0, s.jsx)(f.B, {
                          fontSize: 11,
                          tick: { fill: "#9A9A9E" },
                          axisLine: !1,
                          tickLine: !1,
                          tickFormatter: (e) => "$".concat(e / 1e3, "k"),
                        }),
                        (0, s.jsx)(x.u, {
                          formatter: (e) => [
                            "$".concat(e.toLocaleString()),
                            "",
                          ],
                        }),
                        (0, s.jsx)(j.$, {
                          dataKey: "income",
                          fill: "#22C55E",
                          radius: [6, 6, 0, 0],
                          name: "Income",
                        }),
                        (0, s.jsx)(j.$, {
                          dataKey: "expenses",
                          fill: "#FF6B6B",
                          radius: [6, 6, 0, 0],
                          name: "Expenses",
                        }),
                      ],
                    }),
                  }),
                }),
              ],
            }),
            (0, s.jsxs)("div", {
              className: "mx-6 mt-3 p-4",
              style: {
                background: "#fff",
                borderRadius: 20,
                animation: "fadeInUp 0.5s ease-out 0.3s both",
              },
              children: [
                (0, s.jsx)("div", {
                  style: {
                    fontSize: 14,
                    fontWeight: 700,
                    color: es.ink,
                    marginBottom: 12,
                  },
                  children: "Spending by Category",
                }),
                (0, s.jsxs)("div", {
                  style: { display: "flex", alignItems: "center", gap: 16 },
                  children: [
                    (0, s.jsx)("div", {
                      style: { width: 140, height: 140, flexShrink: 0 },
                      children: (0, s.jsx)(a.h, {
                        width: "100%",
                        height: "100%",
                        children: (0, s.jsxs)(g.u, {
                          children: [
                            (0, s.jsx)(u.b, {
                              data: n,
                              cx: "50%",
                              cy: "50%",
                              innerRadius: 32,
                              outerRadius: 60,
                              paddingAngle: 3,
                              dataKey: "value",
                              children: n.map((e, t) =>
                                (0, s.jsx)(
                                  m.b,
                                  { fill: e.color, stroke: "none" },
                                  t,
                                ),
                              ),
                            }),
                            (0, s.jsx)(x.u, {
                              formatter: (e) => ["$".concat(e), "Spent"],
                            }),
                          ],
                        }),
                      }),
                    }),
                    (0, s.jsx)("div", {
                      className: "flex flex-col gap-2",
                      style: { flex: 1 },
                      children: n.map((e, t) =>
                        (0, s.jsxs)(
                          "div",
                          {
                            className: "flex items-center justify-between",
                            style: {
                              animation: "fadeInUp 0.3s ease-out ".concat(
                                0.3 + 0.05 * t,
                                "s both",
                              ),
                            },
                            children: [
                              (0, s.jsxs)("div", {
                                className: "flex items-center gap-2",
                                children: [
                                  (0, s.jsx)("div", {
                                    style: {
                                      width: 8,
                                      height: 8,
                                      borderRadius: 999,
                                      background: e.color,
                                    },
                                  }),
                                  (0, s.jsx)("span", {
                                    style: {
                                      fontSize: 12,
                                      fontWeight: 500,
                                      color: es.ink,
                                    },
                                    children: e.name,
                                  }),
                                ],
                              }),
                              (0, s.jsxs)("span", {
                                style: {
                                  fontSize: 12,
                                  fontWeight: 600,
                                  color: es.ink,
                                },
                                children: ["$", e.value.toLocaleString()],
                              }),
                            ],
                          },
                          e.name,
                        ),
                      ),
                    }),
                  ],
                }),
              ],
            }),
            (0, s.jsx)("div", { style: { height: 20 } }),
          ],
        });
      }
      function ep(e) {
        let { showToast: t, onNavigate: i } = e,
          [o, r] = (0, n.useState)([
            {
              name: "Housing",
              spent: 1850,
              limit: 2200,
              color: "#FF6B6B",
              icon: "\uD83C\uDFE0",
            },
            {
              name: "Food & Dining",
              spent: 720,
              limit: 800,
              color: "#FF9F0A",
              icon: "\uD83C\uDF55",
            },
            {
              name: "Transport",
              spent: 410,
              limit: 500,
              color: "#0A84FF",
              icon: "\uD83D\uDE97",
            },
            {
              name: "Shopping",
              spent: 820,
              limit: 600,
              color: "#8B5CF6",
              icon: "\uD83D\uDECD️",
              over: !0,
            },
            {
              name: "Bills & Utilities",
              spent: 580,
              limit: 700,
              color: "#22C55E",
              icon: "\uD83D\uDCC4",
            },
            {
              name: "Entertainment",
              spent: 240,
              limit: 300,
              color: "#FF69B4",
              icon: "\uD83C\uDFAC",
            },
          ]),
          l = o.reduce((e, t) => e + t.limit, 0),
          a = o.reduce((e, t) => e + t.spent, 0),
          d = o.filter((e) => e.over);
        return (0, s.jsxs)("div", {
          className: "flex flex-col h-full",
          style: { background: es.bg, overflowY: "auto" },
          children: [
            (0, s.jsxs)("div", {
              className: "flex items-center justify-between px-6 pt-4 pb-2",
              children: [
                (0, s.jsx)(er, {
                  onPress: () => i("dashboard"),
                  style: {
                    width: 40,
                    height: 40,
                    borderRadius: 999,
                    background: "#fff",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                  },
                  children: (0, s.jsx)(G.Z, { size: 16, color: es.ink }),
                }),
                (0, s.jsx)("div", {
                  style: { fontSize: 17, fontWeight: 700, color: es.ink },
                  children: "Budgets",
                }),
                (0, s.jsx)(er, {
                  onPress: () => t("Add new budget"),
                  style: {
                    width: 40,
                    height: 40,
                    borderRadius: 999,
                    background: "#fff",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                  },
                  children: (0, s.jsx)(k.Z, { size: 18, color: es.ink }),
                }),
              ],
            }),
            (0, s.jsxs)("div", {
              className: "mx-6 mt-2 p-4",
              style: {
                background: "linear-gradient(135deg, #22C55E, #16A34A)",
                borderRadius: 24,
                animation: "fadeInUp 0.5s ease-out",
              },
              children: [
                (0, s.jsx)("div", {
                  style: {
                    fontSize: 12,
                    fontWeight: 600,
                    color: "rgba(255,255,255,0.7)",
                  },
                  children: "Total Budget",
                }),
                (0, s.jsxs)("div", {
                  style: {
                    fontSize: 34,
                    fontWeight: 700,
                    color: "#fff",
                    marginTop: 2,
                  },
                  children: ["$", l.toLocaleString()],
                }),
                (0, s.jsxs)("div", {
                  className: "flex items-center gap-4 mt-3",
                  children: [
                    (0, s.jsxs)("div", {
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 12,
                            fontWeight: 600,
                            color: "rgba(255,255,255,0.7)",
                          },
                          children: "Spent",
                        }),
                        (0, s.jsxs)("div", {
                          style: {
                            fontSize: 18,
                            fontWeight: 700,
                            color: "#fff",
                          },
                          children: ["$", a.toLocaleString()],
                        }),
                      ],
                    }),
                    (0, s.jsxs)("div", {
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 12,
                            fontWeight: 600,
                            color: "rgba(255,255,255,0.7)",
                          },
                          children: "Remaining",
                        }),
                        (0, s.jsxs)("div", {
                          style: {
                            fontSize: 18,
                            fontWeight: 700,
                            color: "#fff",
                          },
                          children: ["$", (l - a).toLocaleString()],
                        }),
                      ],
                    }),
                    (0, s.jsxs)("div", {
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 12,
                            fontWeight: 600,
                            color: "rgba(255,255,255,0.7)",
                          },
                          children: "% Used",
                        }),
                        (0, s.jsxs)("div", {
                          style: {
                            fontSize: 18,
                            fontWeight: 700,
                            color: "#fff",
                          },
                          children: [Math.round((a / l) * 100), "%"],
                        }),
                      ],
                    }),
                  ],
                }),
              ],
            }),
            d.length > 0 &&
              (0, s.jsxs)("div", {
                className: "mx-6 mt-3 p-3",
                style: {
                  background: "#FEF2F2",
                  borderRadius: 16,
                  display: "flex",
                  alignItems: "center",
                  gap: 10,
                  animation: "fadeInUp 0.4s ease-out 0.1s both",
                },
                children: [
                  (0, s.jsx)(ee.Z, { size: 18, color: "#FF6B6B" }),
                  (0, s.jsxs)("span", {
                    style: {
                      fontSize: 12.5,
                      fontWeight: 600,
                      color: "#B91C1C",
                    },
                    children: [
                      d.map((e) => "".concat(e.name)).join(", "),
                      " over budget!",
                    ],
                  }),
                ],
              }),
            (0, s.jsxs)("div", {
              className: "px-6 pt-4 pb-6",
              children: [
                (0, s.jsx)("div", {
                  style: {
                    fontSize: 13,
                    fontWeight: 700,
                    color: es.sub,
                    letterSpacing: 0.5,
                    marginBottom: 10,
                    marginLeft: 2,
                  },
                  children: "ALL BUDGETS",
                }),
                o.map((e, i) => {
                  let n = Math.min(Math.round((e.spent / e.limit) * 100), 100);
                  return (0, s.jsxs)(
                    er,
                    {
                      onPress: () =>
                        t(
                          ""
                            .concat(e.name, ": $")
                            .concat(e.spent, " of $")
                            .concat(e.limit),
                        ),
                      style: {
                        background: "#fff",
                        borderRadius: 16,
                        padding: "14px 16px",
                        marginBottom: 8,
                        animation: "fadeInUp 0.4s ease-out ".concat(
                          0.15 + 0.06 * i,
                          "s both",
                        ),
                      },
                      children: [
                        (0, s.jsxs)("div", {
                          className: "flex items-center justify-between mb-2",
                          children: [
                            (0, s.jsxs)("div", {
                              className: "flex items-center gap-2",
                              children: [
                                (0, s.jsx)("span", {
                                  style: { fontSize: 18 },
                                  children: e.icon,
                                }),
                                (0, s.jsx)("span", {
                                  style: {
                                    fontSize: 14,
                                    fontWeight: 600,
                                    color: es.ink,
                                  },
                                  children: e.name,
                                }),
                              ],
                            }),
                            (0, s.jsxs)("div", {
                              className: "flex items-center gap-2",
                              children: [
                                (0, s.jsxs)("span", {
                                  style: {
                                    fontSize: 14,
                                    fontWeight: 700,
                                    color: e.over ? "#FF6B6B" : es.ink,
                                  },
                                  children: ["$", e.spent.toLocaleString()],
                                }),
                                (0, s.jsxs)("span", {
                                  style: { fontSize: 12, color: es.sub },
                                  children: ["/ $", e.limit.toLocaleString()],
                                }),
                              ],
                            }),
                          ],
                        }),
                        (0, s.jsx)("div", {
                          style: {
                            height: 8,
                            borderRadius: 999,
                            background: es.chip,
                            overflow: "hidden",
                          },
                          children: (0, s.jsx)("div", {
                            style: {
                              width: "".concat(n, "%"),
                              height: "100%",
                              borderRadius: 999,
                              background: e.over ? "#FF6B6B" : e.color,
                              transition:
                                "width 0.8s cubic-bezier(0.34,1.56,0.64,1)",
                            },
                          }),
                        }),
                        (0, s.jsxs)("div", {
                          className: "flex items-center justify-between mt-1.5",
                          children: [
                            (0, s.jsxs)("span", {
                              style: {
                                fontSize: 11,
                                color: e.over ? "#FF6B6B" : es.sub,
                                fontWeight: 500,
                              },
                              children: [n, "% used"],
                            }),
                            e.over &&
                              (0, s.jsxs)("span", {
                                style: {
                                  fontSize: 11,
                                  fontWeight: 700,
                                  color: "#FF6B6B",
                                },
                                children: [
                                  "$",
                                  (e.spent - e.limit).toLocaleString(),
                                  " over",
                                ],
                              }),
                            !e.over &&
                              (0, s.jsxs)("span", {
                                style: {
                                  fontSize: 11,
                                  fontWeight: 500,
                                  color: es.green,
                                },
                                children: [
                                  "$",
                                  (e.limit - e.spent).toLocaleString(),
                                  " left",
                                ],
                              }),
                          ],
                        }),
                      ],
                    },
                    e.name,
                  );
                }),
              ],
            }),
          ],
        });
      }
      function eg(e) {
        let { showToast: t, onNavigate: i } = e,
          [o, r] = (0, n.useState)([
            {
              name: "Netflix Premium",
              amount: 15.99,
              date: "16th",
              icon: "\uD83C\uDFAC",
              color: "#E50914",
              category: "Entertainment",
            },
            {
              name: "Spotify Family",
              amount: 14.99,
              date: "22nd",
              icon: "\uD83C\uDFB5",
              color: "#1DB954",
              category: "Music",
            },
            {
              name: "iCloud+ 2TB",
              amount: 9.99,
              date: "5th",
              icon: "☁️",
              color: "#007AFF",
              category: "Cloud",
            },
            {
              name: "FitLife Gym",
              amount: 49.99,
              date: "1st",
              icon: "\uD83D\uDCAA",
              color: "#FF6B6B",
              category: "Health",
            },
            {
              name: "ChatGPT Plus",
              amount: 20,
              date: "3rd",
              icon: "\uD83E\uDD16",
              color: "#10A37F",
              category: "AI",
            },
            {
              name: "Amazon Prime",
              amount: 14.99,
              date: "12th",
              icon: "\uD83D\uDCE6",
              color: "#FF9900",
              category: "Shopping",
            },
            {
              name: "Disney+",
              amount: 7.99,
              date: "8th",
              icon: "✨",
              color: "#113CCF",
              category: "Entertainment",
            },
            {
              name: "Medium",
              amount: 5,
              date: "15th",
              icon: "\uD83D\uDCDD",
              color: "#000000",
              category: "Reading",
            },
          ]),
          l = o.reduce((e, t) => e + t.amount, 0),
          a = [...new Set(o.map((e) => e.category))].map((e) => ({
            name: e,
            total: o
              .filter((t) => t.category === e)
              .reduce((e, t) => e + t.amount, 0),
            count: o.filter((t) => t.category === e).length,
            subs: o.filter((t) => t.category === e),
          }));
        return (0, s.jsxs)("div", {
          className: "flex flex-col h-full",
          style: { background: es.bg, overflowY: "auto" },
          children: [
            (0, s.jsxs)("div", {
              className: "flex items-center justify-between px-6 pt-4 pb-2",
              children: [
                (0, s.jsx)(er, {
                  onPress: () => i("dashboard"),
                  style: {
                    width: 40,
                    height: 40,
                    borderRadius: 999,
                    background: "#fff",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                  },
                  children: (0, s.jsx)(G.Z, { size: 16, color: es.ink }),
                }),
                (0, s.jsx)("div", {
                  style: { fontSize: 17, fontWeight: 700, color: es.ink },
                  children: "Subscriptions",
                }),
                (0, s.jsx)(er, {
                  onPress: () => t("Add subscription"),
                  style: {
                    width: 40,
                    height: 40,
                    borderRadius: 999,
                    background: "#fff",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                  },
                  children: (0, s.jsx)(k.Z, { size: 18, color: es.ink }),
                }),
              ],
            }),
            (0, s.jsxs)("div", {
              className: "mx-6 mt-2 p-5",
              style: {
                background: "linear-gradient(135deg, #FF9F0A, #FF6B6B)",
                borderRadius: 24,
                animation: "fadeInUp 0.5s ease-out",
              },
              children: [
                (0, s.jsx)("div", {
                  style: {
                    fontSize: 12,
                    fontWeight: 600,
                    color: "rgba(255,255,255,0.7)",
                  },
                  children: "Monthly Subscriptions",
                }),
                (0, s.jsxs)("div", {
                  style: {
                    fontSize: 34,
                    fontWeight: 700,
                    color: "#fff",
                    marginTop: 2,
                    letterSpacing: -1,
                  },
                  children: ["$", l.toFixed(2)],
                }),
                (0, s.jsxs)("div", {
                  className: "flex items-center gap-4 mt-3",
                  children: [
                    (0, s.jsxs)("div", {
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 12,
                            fontWeight: 600,
                            color: "rgba(255,255,255,0.7)",
                          },
                          children: "Yearly",
                        }),
                        (0, s.jsxs)("div", {
                          style: {
                            fontSize: 18,
                            fontWeight: 700,
                            color: "#fff",
                          },
                          children: ["$", (12 * l).toFixed(2)],
                        }),
                      ],
                    }),
                    (0, s.jsxs)("div", {
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 12,
                            fontWeight: 600,
                            color: "rgba(255,255,255,0.7)",
                          },
                          children: "Services",
                        }),
                        (0, s.jsx)("div", {
                          style: {
                            fontSize: 18,
                            fontWeight: 700,
                            color: "#fff",
                          },
                          children: o.length,
                        }),
                      ],
                    }),
                  ],
                }),
              ],
            }),
            (0, s.jsxs)("div", {
              className: "px-6 pt-4",
              children: [
                (0, s.jsx)("div", {
                  style: {
                    fontSize: 13,
                    fontWeight: 700,
                    color: es.sub,
                    letterSpacing: 0.5,
                    marginBottom: 8,
                    marginLeft: 2,
                  },
                  children: "BY CATEGORY",
                }),
                a.map((e, i) =>
                  (0, s.jsxs)(
                    er,
                    {
                      onPress: () =>
                        t("".concat(e.name, ": ").concat(e.count, " services")),
                      style: {
                        background: "#fff",
                        borderRadius: 16,
                        padding: "12px 16px",
                        marginBottom: 6,
                        animation: "fadeInUp 0.4s ease-out ".concat(
                          0.1 + 0.05 * i,
                          "s both",
                        ),
                      },
                      children: [
                        (0, s.jsxs)("div", {
                          className: "flex items-center justify-between",
                          children: [
                            (0, s.jsxs)("div", {
                              className: "flex items-center gap-2",
                              children: [
                                (0, s.jsx)("span", {
                                  style: {
                                    fontSize: 14,
                                    fontWeight: 600,
                                    color: es.ink,
                                  },
                                  children: e.name,
                                }),
                                (0, s.jsx)("span", {
                                  style: {
                                    fontSize: 11,
                                    color: es.sub,
                                    background: es.chip,
                                    padding: "2px 8px",
                                    borderRadius: 999,
                                  },
                                  children: e.count,
                                }),
                              ],
                            }),
                            (0, s.jsxs)("span", {
                              style: {
                                fontSize: 14,
                                fontWeight: 700,
                                color: es.ink,
                              },
                              children: ["$", e.total.toFixed(2)],
                            }),
                          ],
                        }),
                        (0, s.jsx)("div", {
                          style: { fontSize: 11, color: es.sub, marginTop: 2 },
                          children: e.subs.map((e) => e.name).join(", "),
                        }),
                      ],
                    },
                    e.name,
                  ),
                ),
              ],
            }),
            (0, s.jsxs)("div", {
              className: "px-6 pt-4 pb-6",
              children: [
                (0, s.jsx)("div", {
                  style: {
                    fontSize: 13,
                    fontWeight: 700,
                    color: es.sub,
                    letterSpacing: 0.5,
                    marginBottom: 8,
                    marginLeft: 2,
                  },
                  children: "ALL SERVICES",
                }),
                o.map((e, i) => {
                  let n = Math.round((e.amount / l) * 100);
                  return (0, s.jsxs)(
                    "div",
                    {
                      style: {
                        display: "flex",
                        alignItems: "center",
                        gap: 12,
                        padding: "12px 14px",
                        background: "#fff",
                        borderRadius: 16,
                        marginBottom: 6,
                        animation: "fadeInUp 0.4s ease-out ".concat(
                          0.2 + 0.05 * i,
                          "s both",
                        ),
                      },
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            width: 40,
                            height: 40,
                            borderRadius: 12,
                            background: e.color + "15",
                            display: "flex",
                            alignItems: "center",
                            justifyContent: "center",
                            fontSize: 20,
                          },
                          children: e.icon,
                        }),
                        (0, s.jsxs)("div", {
                          style: { flex: 1 },
                          children: [
                            (0, s.jsx)("div", {
                              style: {
                                fontSize: 13.5,
                                fontWeight: 600,
                                color: es.ink,
                              },
                              children: e.name,
                            }),
                            (0, s.jsxs)("div", {
                              style: { fontSize: 11, color: es.sub },
                              children: [
                                "Bills ",
                                e.date,
                                " \xb7 ",
                                n,
                                "% of total",
                              ],
                            }),
                          ],
                        }),
                        (0, s.jsxs)("div", {
                          style: { textAlign: "right" },
                          children: [
                            (0, s.jsxs)("div", {
                              style: {
                                fontSize: 14,
                                fontWeight: 700,
                                color: es.ink,
                              },
                              children: ["$", e.amount.toFixed(2)],
                            }),
                            (0, s.jsx)("div", {
                              style: { fontSize: 11, color: es.sub },
                              children: "/mo",
                            }),
                          ],
                        }),
                        (0, s.jsx)(er, {
                          onPress: () => t("".concat(e.name, " details")),
                          style: {
                            width: 28,
                            height: 28,
                            borderRadius: 999,
                            background: es.chip,
                            display: "flex",
                            alignItems: "center",
                            justifyContent: "center",
                          },
                          children: (0, s.jsx)(ChevronRight, {
                            size: 13,
                            color: es.sub,
                          }),
                        }),
                      ],
                    },
                    e.name,
                  );
                }),
              ],
            }),
            (0, s.jsxs)("div", {
              className: "mx-6 mb-6 p-4",
              style: {
                background: "linear-gradient(135deg, #EDE9FE, #F3E8FF)",
                borderRadius: 20,
                display: "flex",
                alignItems: "center",
                gap: 12,
              },
              children: [
                (0, s.jsx)("div", {
                  style: {
                    width: 44,
                    height: 44,
                    borderRadius: 14,
                    background: "#8B5CF6",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                  },
                  children: (0, s.jsx)(ee.Z, { size: 20, color: "#fff" }),
                }),
                (0, s.jsxs)("div", {
                  style: { flex: 1 },
                  children: [
                    (0, s.jsx)("div", {
                      style: { fontSize: 14, fontWeight: 700, color: es.ink },
                      children: "Potential Savings",
                    }),
                    (0, s.jsxs)("div", {
                      style: { fontSize: 12, color: es.sub },
                      children: [
                        "You could save up to ",
                        (0, s.jsx)("strong", { children: "$48.97/mo" }),
                        " by reviewing unused subscriptions",
                      ],
                    }),
                  ],
                }),
                (0, s.jsx)(V.Z, { size: 16, color: "#8B5CF6" }),
              ],
            }),
          ],
        });
      }
      function eu() {
        let [e, t] = (0, n.useState)("dashboard"),
          [i, o] = (0, n.useState)(null),
          [r, l] = (0, n.useState)(null),
          [a, d] = (0, n.useState)("fadeIn"),
          [c, h] = (0, n.useState)(
            () => "true" === localStorage.getItem("finance-dark-mode"),
          );
        (0, n.useEffect)(() => {
          "undefined" != typeof document &&
            (document.documentElement.style.setProperty(
              "--app-bg",
              c ? "#0E0E12" : "#F1F0ED",
            ),
            localStorage.setItem("finance-dark-mode", c ? "true" : "false"));
        }, [c]);
        let f = (0, n.useCallback)((e) => {
            o(e);
          }, []),
          x = (0, n.useCallback)((e, t) => l({ title: e, content: t }), []),
          p = (0, n.useCallback)((e) => {
            d("fadeOut"),
              setTimeout(() => {
                t(e), d("fadeIn");
              }, 150);
          }, []),
          g = (0, n.useCallback)(() => {
            h((e) => !e), f(c ? "Light mode" : "Dark mode");
          }, [c, f]),
          u = (0, n.useCallback)(() => {
            x(
              "Quick Actions",
              (0, s.jsx)("div", {
                className: "flex flex-col gap-3",
                children: [
                  {
                    icon: (0, s.jsx)(w.Z, { size: 18, color: es.green }),
                    label: "Send Money",
                    desc: "Transfer to contacts",
                    action: m,
                  },
                  {
                    icon: (0, s.jsx)(et.Z, { size: 18, color: es.blue }),
                    label: "Request Payment",
                    desc: "Request from someone",
                    action: y,
                  },
                  {
                    icon: (0, s.jsx)(S.Z, { size: 18, color: es.orange }),
                    label: "New Invoice",
                    desc: "Create an invoice",
                    action: j,
                  },
                  {
                    icon: (0, s.jsx)(ei.Z, { size: 18, color: "#8B5CF6" }),
                    label: "Invest",
                    desc: "Start investing",
                    action: b,
                  },
                  {
                    icon: (0, s.jsx)(D.Z, { size: 18, color: "#8B5CF6" }),
                    label: "Analytics",
                    desc: "Spending insights & charts",
                    action: () => p("analytics"),
                  },
                  {
                    icon: (0, s.jsx)(A.Z, { size: 18, color: "#22C55E" }),
                    label: "Budgets",
                    desc: "Track monthly budgets",
                    action: () => p("budgets"),
                  },
                  {
                    icon: (0, s.jsx)(T.Z, { size: 18, color: "#FF9F0A" }),
                    label: "Subscriptions",
                    desc: "Manage recurring payments",
                    action: () => p("subscriptions"),
                  },
                  {
                    icon: c
                      ? (0, s.jsx)(E.Z, { size: 18, color: "#FF9F0A" })
                      : (0, s.jsx)(B.Z, { size: 18, color: "#6B6B6E" }),
                    label: c ? "Light Mode" : "Dark Mode",
                    desc: "Toggle appearance",
                    action: g,
                  },
                ].map((e) =>
                  (0, s.jsxs)(
                    er,
                    {
                      onPress: () => {
                        l(null), setTimeout(e.action, 250);
                      },
                      style: {
                        display: "flex",
                        alignItems: "center",
                        gap: 14,
                        padding: "14px 16px",
                        background: es.chip,
                        borderRadius: 16,
                        animation: "fadeInUp 0.35s ease-out",
                      },
                      children: [
                        (0, s.jsx)("div", {
                          style: {
                            width: 40,
                            height: 40,
                            borderRadius: 12,
                            background: "#fff",
                            display: "flex",
                            alignItems: "center",
                            justifyContent: "center",
                          },
                          children: e.icon,
                        }),
                        (0, s.jsxs)("div", {
                          children: [
                            (0, s.jsx)("div", {
                              style: {
                                fontSize: 15,
                                fontWeight: 600,
                                color: es.ink,
                              },
                              children: e.label,
                            }),
                            (0, s.jsx)("div", {
                              style: { fontSize: 12, color: es.sub },
                              children: e.desc,
                            }),
                          ],
                        }),
                        (0, s.jsx)(V.Z, {
                          size: 16,
                          color: es.faint,
                          style: { marginLeft: "auto" },
                        }),
                      ],
                    },
                    e.label,
                  ),
                ),
              }),
            );
          }, [x, f]),
          m = (0, n.useCallback)(() => {
            x(
              "Send Money",
              (0, s.jsxs)("div", {
                children: [
                  (0, s.jsx)("div", {
                    style: { fontSize: 13, color: es.sub, marginBottom: 10 },
                    children: "Select recipient",
                  }),
                  (0, s.jsx)("div", {
                    style: {
                      display: "grid",
                      gridTemplateColumns: "repeat(3, 1fr)",
                      gap: 10,
                      marginBottom: 16,
                    },
                    children: [
                      {
                        name: "Emma Watson",
                        color: "#FF6B6B",
                        letter: "E",
                        handle: "@emma",
                      },
                      {
                        name: "Noah Chen",
                        color: "#4ECDC4",
                        letter: "N",
                        handle: "@noah",
                      },
                      {
                        name: "Olivia Park",
                        color: "#45B7D1",
                        letter: "O",
                        handle: "@olivia",
                      },
                      {
                        name: "Liam Davis",
                        color: "#96CEB4",
                        letter: "L",
                        handle: "@liam",
                      },
                      {
                        name: "Ava Kim",
                        color: "#FFEAA7",
                        letter: "A",
                        handle: "@ava",
                      },
                      {
                        name: "Mason Lee",
                        color: "#DDA0DD",
                        letter: "M",
                        handle: "@mason",
                      },
                    ].map((e) =>
                      (0, s.jsxs)(
                        er,
                        {
                          onPress: () => {
                            f("Selected ".concat(e.name));
                          },
                          style: {
                            textAlign: "center",
                            padding: "12px 4px",
                            borderRadius: 14,
                            background: es.chip,
                          },
                          children: [
                            (0, s.jsx)("div", {
                              style: {
                                width: 44,
                                height: 44,
                                borderRadius: 999,
                                background: e.color,
                                margin: "0 auto",
                                display: "flex",
                                alignItems: "center",
                                justifyContent: "center",
                              },
                              children: (0, s.jsx)("span", {
                                style: {
                                  fontSize: 18,
                                  fontWeight: 700,
                                  color: "#fff",
                                },
                                children: e.letter,
                              }),
                            }),
                            (0, s.jsx)("div", {
                              style: {
                                fontSize: 11,
                                fontWeight: 600,
                                color: es.ink,
                                marginTop: 6,
                                lineHeight: 1.2,
                              },
                              children: e.name.split(" ")[0],
                            }),
                            (0, s.jsx)("div", {
                              style: { fontSize: 10, color: es.sub },
                              children: e.handle,
                            }),
                          ],
                        },
                        e.name,
                      ),
                    ),
                  }),
                  (0, s.jsx)("div", {
                    style: { fontSize: 13, color: es.sub, marginBottom: 8 },
                    children: "Quick amount",
                  }),
                  (0, s.jsx)("div", {
                    style: {
                      display: "grid",
                      gridTemplateColumns: "repeat(3, 1fr)",
                      gap: 8,
                      marginBottom: 16,
                    },
                    children: ["$10", "$25", "$50", "$100", "$250", "$500"].map(
                      (e) =>
                        (0, s.jsx)(
                          er,
                          {
                            onPress: () => f("Amount set to ".concat(e)),
                            style: {
                              padding: "10px 0",
                              borderRadius: 12,
                              background: es.chip,
                              textAlign: "center",
                            },
                            children: (0, s.jsx)("span", {
                              style: {
                                fontSize: 14,
                                fontWeight: 600,
                                color: es.ink,
                              },
                              children: e,
                            }),
                          },
                          e,
                        ),
                    ),
                  }),
                  (0, s.jsx)("div", {
                    style: { display: "flex", gap: 8 },
                    children: (0, s.jsx)("div", {
                      style: {
                        flex: 1,
                        padding: "12px 14px",
                        borderRadius: 12,
                        border: "1.5px solid ".concat(es.line),
                        fontSize: 14,
                        color: es.sub,
                        background: "#fff",
                      },
                      children: "Custom amount...",
                    }),
                  }),
                  (0, s.jsxs)(er, {
                    onPress: () => f("Money sent successfully! ✓"),
                    style: {
                      width: "100%",
                      padding: "14px 0",
                      borderRadius: 999,
                      background: es.green,
                      display: "flex",
                      alignItems: "center",
                      justifyContent: "center",
                      gap: 8,
                      marginTop: 16,
                    },
                    children: [
                      (0, s.jsx)(w.Z, { size: 16, color: "#fff" }),
                      (0, s.jsx)("span", {
                        style: { fontSize: 15, fontWeight: 700, color: "#fff" },
                        children: "Send Money",
                      }),
                    ],
                  }),
                ],
              }),
            );
          }, [x, f]),
          y = (0, n.useCallback)(() => {
            x(
              "Request Payment",
              (0, s.jsxs)("div", {
                children: [
                  (0, s.jsx)("div", {
                    style: { fontSize: 13, color: es.sub, marginBottom: 10 },
                    children: "Request from",
                  }),
                  (0, s.jsx)("div", {
                    style: { display: "flex", gap: 10, marginBottom: 16 },
                    children: [
                      { name: "Studio Sphere", color: "#FF7A45", letter: "S" },
                      { name: "Dip Inc.", color: es.ink, letter: "D" },
                      { name: "Acme Corp", color: es.blue, letter: "A" },
                    ].map((e) =>
                      (0, s.jsxs)(
                        er,
                        {
                          onPress: () => f("Requesting from ".concat(e.name)),
                          style: {
                            flex: 1,
                            textAlign: "center",
                            padding: "12px 6px",
                            borderRadius: 14,
                            background: es.chip,
                          },
                          children: [
                            (0, s.jsx)("div", {
                              style: {
                                width: 40,
                                height: 40,
                                borderRadius: 999,
                                background: e.color,
                                margin: "0 auto",
                                display: "flex",
                                alignItems: "center",
                                justifyContent: "center",
                              },
                              children: (0, s.jsx)("span", {
                                style: {
                                  fontSize: 16,
                                  fontWeight: 700,
                                  color: "#fff",
                                },
                                children: e.letter,
                              }),
                            }),
                            (0, s.jsx)("div", {
                              style: {
                                fontSize: 11,
                                fontWeight: 600,
                                color: es.ink,
                                marginTop: 6,
                              },
                              children: e.name.split(" ")[0],
                            }),
                          ],
                        },
                        e.name,
                      ),
                    ),
                  }),
                  (0, s.jsx)("div", {
                    style: { fontSize: 13, color: es.sub, marginBottom: 8 },
                    children: "Amount",
                  }),
                  (0, s.jsxs)("div", {
                    style: {
                      padding: "14px 16px",
                      borderRadius: 14,
                      border: "1.5px solid ".concat(es.line),
                      background: "#fff",
                      marginBottom: 12,
                      display: "flex",
                      alignItems: "center",
                      gap: 8,
                    },
                    children: [
                      (0, s.jsx)("span", {
                        style: { fontSize: 20, fontWeight: 700, color: es.ink },
                        children: "$",
                      }),
                      (0, s.jsx)("span", {
                        style: { fontSize: 20, fontWeight: 600, color: es.sub },
                        children: "0.00",
                      }),
                    ],
                  }),
                  (0, s.jsx)("div", {
                    style: { fontSize: 13, color: es.sub, marginBottom: 8 },
                    children: "Note (optional)",
                  }),
                  (0, s.jsx)("div", {
                    style: {
                      padding: "12px 16px",
                      borderRadius: 14,
                      border: "1.5px solid ".concat(es.line),
                      background: "#fff",
                      marginBottom: 16,
                      fontSize: 14,
                      color: es.sub,
                    },
                    children: "e.g. For design work...",
                  }),
                  (0, s.jsx)("div", {
                    style: { display: "flex", gap: 8, marginBottom: 12 },
                    children: ["$100", "$500", "$1,000"].map((e) =>
                      (0, s.jsx)(
                        er,
                        {
                          onPress: () => f("Amount: ".concat(e)),
                          style: {
                            flex: 1,
                            padding: "10px 0",
                            borderRadius: 12,
                            background: es.chip,
                            textAlign: "center",
                          },
                          children: (0, s.jsx)("span", {
                            style: {
                              fontSize: 13,
                              fontWeight: 600,
                              color: es.ink,
                            },
                            children: e,
                          }),
                        },
                        e,
                      ),
                    ),
                  }),
                  (0, s.jsxs)(er, {
                    onPress: () => f("Payment request sent! ✓"),
                    style: {
                      width: "100%",
                      padding: "14px 0",
                      borderRadius: 999,
                      background: es.blue,
                      display: "flex",
                      alignItems: "center",
                      justifyContent: "center",
                      gap: 8,
                    },
                    children: [
                      (0, s.jsx)(et.Z, { size: 16, color: "#fff" }),
                      (0, s.jsx)("span", {
                        style: { fontSize: 15, fontWeight: 700, color: "#fff" },
                        children: "Request Payment",
                      }),
                    ],
                  }),
                ],
              }),
            );
          }, [x, f]),
          j = (0, n.useCallback)(() => {
            x(
              "New Invoice",
              (0, s.jsxs)("div", {
                children: [
                  (0, s.jsxs)("div", {
                    style: { display: "flex", gap: 10, marginBottom: 16 },
                    children: [
                      (0, s.jsxs)("div", {
                        style: { flex: 1 },
                        children: [
                          (0, s.jsx)("div", {
                            style: {
                              fontSize: 11,
                              color: es.sub,
                              letterSpacing: 0.5,
                              marginBottom: 6,
                            },
                            children: "FROM",
                          }),
                          (0, s.jsxs)("div", {
                            style: {
                              padding: "12px 14px",
                              borderRadius: 12,
                              border: "1.5px solid ".concat(es.line),
                              background: "#fff",
                              display: "flex",
                              alignItems: "center",
                              gap: 8,
                            },
                            children: [
                              (0, s.jsx)("div", {
                                style: {
                                  width: 24,
                                  height: 24,
                                  borderRadius: 999,
                                  background: "#FF7A45",
                                },
                              }),
                              (0, s.jsx)("span", {
                                style: {
                                  fontSize: 13,
                                  fontWeight: 600,
                                  color: es.ink,
                                },
                                children: "Studio Sphere",
                              }),
                            ],
                          }),
                        ],
                      }),
                      (0, s.jsxs)("div", {
                        style: { flex: 1 },
                        children: [
                          (0, s.jsx)("div", {
                            style: {
                              fontSize: 11,
                              color: es.sub,
                              letterSpacing: 0.5,
                              marginBottom: 6,
                            },
                            children: "BILL TO",
                          }),
                          (0, s.jsxs)("div", {
                            style: {
                              padding: "12px 14px",
                              borderRadius: 12,
                              border: "1.5px solid ".concat(es.line),
                              background: "#fff",
                              display: "flex",
                              alignItems: "center",
                              gap: 8,
                            },
                            children: [
                              (0, s.jsx)("div", {
                                style: {
                                  width: 24,
                                  height: 24,
                                  borderRadius: 999,
                                  background: es.ink,
                                },
                              }),
                              (0, s.jsx)("span", {
                                style: {
                                  fontSize: 13,
                                  fontWeight: 600,
                                  color: es.ink,
                                },
                                children: "Dip Inc.",
                              }),
                            ],
                          }),
                        ],
                      }),
                    ],
                  }),
                  (0, s.jsx)("div", {
                    style: { fontSize: 13, color: es.sub, marginBottom: 8 },
                    children: "Line items",
                  }),
                  ["Design", "Development", "Consulting"].map((e, t) =>
                    (0, s.jsxs)(
                      "div",
                      {
                        style: {
                          display: "flex",
                          alignItems: "center",
                          gap: 8,
                          padding: "10px 12px",
                          borderRadius: 12,
                          background: es.chip,
                          marginBottom: 6,
                        },
                        children: [
                          (0, s.jsx)("div", {
                            style: {
                              width: 8,
                              height: 8,
                              borderRadius: 999,
                              background: [es.blue, es.green, es.orange][t],
                            },
                          }),
                          (0, s.jsx)("span", {
                            style: {
                              fontSize: 14,
                              fontWeight: 600,
                              color: es.ink,
                              flex: 1,
                            },
                            children: e,
                          }),
                          (0, s.jsxs)("span", {
                            style: { fontSize: 13, color: es.sub },
                            children: [
                              "$",
                              [2400, 6840, 2e3][t].toLocaleString(),
                            ],
                          }),
                        ],
                      },
                      e,
                    ),
                  ),
                  (0, s.jsxs)(er, {
                    onPress: () => f("Add line item"),
                    style: {
                      padding: "10px 14px",
                      borderRadius: 12,
                      border: "1.5px dashed ".concat(es.line),
                      display: "flex",
                      alignItems: "center",
                      justifyContent: "center",
                      gap: 6,
                      marginBottom: 16,
                    },
                    children: [
                      (0, s.jsx)(k.Z, { size: 14, color: es.sub }),
                      (0, s.jsx)("span", {
                        style: { fontSize: 13, fontWeight: 600, color: es.sub },
                        children: "Add line item",
                      }),
                    ],
                  }),
                  (0, s.jsxs)("div", {
                    style: {
                      display: "flex",
                      justifyContent: "space-between",
                      padding: "12px 0",
                      borderTop: "1px solid ".concat(es.line),
                    },
                    children: [
                      (0, s.jsx)("span", {
                        style: { fontSize: 13, fontWeight: 600, color: es.sub },
                        children: "TOTAL",
                      }),
                      (0, s.jsx)("span", {
                        style: { fontSize: 18, fontWeight: 700, color: es.ink },
                        children: "$11,240",
                      }),
                    ],
                  }),
                  (0, s.jsxs)("div", {
                    style: { display: "flex", gap: 10, marginTop: 4 },
                    children: [
                      (0, s.jsxs)("div", {
                        style: { flex: 1 },
                        children: [
                          (0, s.jsx)("div", {
                            style: {
                              fontSize: 11,
                              color: es.sub,
                              marginBottom: 4,
                            },
                            children: "DUE DATE",
                          }),
                          (0, s.jsx)("div", {
                            style: {
                              padding: "10px 12px",
                              borderRadius: 12,
                              border: "1.5px solid ".concat(es.line),
                              background: "#fff",
                              fontSize: 13,
                              fontWeight: 600,
                              color: es.ink,
                            },
                            children: "20 May 2026",
                          }),
                        ],
                      }),
                      (0, s.jsxs)("div", {
                        style: { flex: 1 },
                        children: [
                          (0, s.jsx)("div", {
                            style: {
                              fontSize: 11,
                              color: es.sub,
                              marginBottom: 4,
                            },
                            children: "TERMS",
                          }),
                          (0, s.jsx)("div", {
                            style: {
                              padding: "10px 12px",
                              borderRadius: 12,
                              border: "1.5px solid ".concat(es.line),
                              background: "#fff",
                              fontSize: 13,
                              fontWeight: 600,
                              color: es.ink,
                            },
                            children: "Net 14",
                          }),
                        ],
                      }),
                    ],
                  }),
                  (0, s.jsxs)(er, {
                    onPress: () => f("Invoice created! ✓"),
                    style: {
                      width: "100%",
                      padding: "14px 0",
                      borderRadius: 999,
                      background: es.orange,
                      display: "flex",
                      alignItems: "center",
                      justifyContent: "center",
                      gap: 8,
                      marginTop: 16,
                    },
                    children: [
                      (0, s.jsx)(S.Z, { size: 16, color: "#fff" }),
                      (0, s.jsx)("span", {
                        style: { fontSize: 15, fontWeight: 700, color: "#fff" },
                        children: "Create Invoice",
                      }),
                    ],
                  }),
                ],
              }),
            );
          }, [x, f]),
          b = (0, n.useCallback)(() => {
            x(
              "Invest",
              (0, s.jsxs)("div", {
                children: [
                  (0, s.jsx)("div", {
                    style: { display: "flex", gap: 8, marginBottom: 16 },
                    children: ["Stocks", "Crypto", "ETFs"].map((e, t) =>
                      (0, s.jsx)(
                        er,
                        {
                          onPress: () => f("Viewing ".concat(e)),
                          style: {
                            flex: 1,
                            padding: "10px 0",
                            borderRadius: 12,
                            background: 0 === t ? es.ink : es.chip,
                            textAlign: "center",
                          },
                          children: (0, s.jsx)("span", {
                            style: {
                              fontSize: 13,
                              fontWeight: 600,
                              color: 0 === t ? "#fff" : es.ink,
                            },
                            children: e,
                          }),
                        },
                        e,
                      ),
                    ),
                  }),
                  (0, s.jsx)("div", {
                    style: { fontSize: 13, color: es.sub, marginBottom: 10 },
                    children: "Popular stocks",
                  }),
                  [
                    {
                      name: "Apple",
                      ticker: "AAPL",
                      price: "$183.63",
                      change: "+2.05%",
                      up: !0,
                      color: "#a2aaad",
                    },
                    {
                      name: "Tesla",
                      ticker: "TSLA",
                      price: "$265.28",
                      change: "+1.02%",
                      up: !0,
                      color: "#cc0000",
                    },
                    {
                      name: "NVIDIA",
                      ticker: "NVDA",
                      price: "$831.74",
                      change: "+0.58%",
                      up: !0,
                      color: "#76b900",
                    },
                    {
                      name: "Amazon",
                      ticker: "AMZN",
                      price: "$186.33",
                      change: "+1.10%",
                      up: !0,
                      color: "#ff9900",
                    },
                    {
                      name: "Microsoft",
                      ticker: "MSFT",
                      price: "$376.04",
                      change: "+0.98%",
                      up: !0,
                      color: "#00a4ef",
                    },
                  ].map((e) =>
                    (0, s.jsxs)(
                      er,
                      {
                        onPress: () => f("Buy ".concat(e.name, "?")),
                        style: {
                          display: "flex",
                          alignItems: "center",
                          gap: 12,
                          padding: "12px 14px",
                          borderRadius: 14,
                          background: es.chip,
                          marginBottom: 6,
                        },
                        children: [
                          (0, s.jsx)("div", {
                            style: {
                              width: 38,
                              height: 38,
                              borderRadius: 10,
                              background: e.color + "25",
                              display: "flex",
                              alignItems: "center",
                              justifyContent: "center",
                            },
                            children: (0, s.jsx)("span", {
                              style: {
                                fontSize: 14,
                                fontWeight: 700,
                                color: e.color,
                              },
                              children: e.ticker[0],
                            }),
                          }),
                          (0, s.jsxs)("div", {
                            style: { flex: 1 },
                            children: [
                              (0, s.jsx)("div", {
                                style: {
                                  fontSize: 14,
                                  fontWeight: 600,
                                  color: es.ink,
                                },
                                children: e.name,
                              }),
                              (0, s.jsx)("div", {
                                style: { fontSize: 11, color: es.sub },
                                children: e.ticker,
                              }),
                            ],
                          }),
                          (0, s.jsxs)("div", {
                            style: { textAlign: "right" },
                            children: [
                              (0, s.jsx)("div", {
                                style: {
                                  fontSize: 14,
                                  fontWeight: 600,
                                  color: es.ink,
                                },
                                children: e.price,
                              }),
                              (0, s.jsx)("div", {
                                style: {
                                  fontSize: 11,
                                  fontWeight: 600,
                                  color: es.green,
                                },
                                children: e.change,
                              }),
                            ],
                          }),
                        ],
                      },
                      e.ticker,
                    ),
                  ),
                  (0, s.jsx)(er, {
                    onPress: () => f("Browse all investments"),
                    style: {
                      padding: "12px 0",
                      borderRadius: 12,
                      border: "1.5px solid ".concat(es.line),
                      display: "flex",
                      alignItems: "center",
                      justifyContent: "center",
                      gap: 6,
                      marginTop: 4,
                      marginBottom: 12,
                    },
                    children: (0, s.jsx)("span", {
                      style: { fontSize: 13, fontWeight: 600, color: es.sub },
                      children: "Browse all →",
                    }),
                  }),
                  (0, s.jsxs)("div", {
                    style: {
                      padding: "14px 16px",
                      borderRadius: 16,
                      background: "linear-gradient(135deg, #EDE9FE, #F3E8FF)",
                      display: "flex",
                      alignItems: "center",
                      gap: 12,
                      marginBottom: 12,
                    },
                    children: [
                      (0, s.jsx)(ei.Z, { size: 20, color: "#8B5CF6" }),
                      (0, s.jsxs)("div", {
                        children: [
                          (0, s.jsx)("div", {
                            style: {
                              fontSize: 14,
                              fontWeight: 700,
                              color: es.ink,
                            },
                            children: "Start with as little as $1",
                          }),
                          (0, s.jsx)("div", {
                            style: { fontSize: 12, color: es.sub },
                            children: "No commission on first trade",
                          }),
                        ],
                      }),
                    ],
                  }),
                  (0, s.jsxs)(er, {
                    onPress: () => f("Investment started! ✓"),
                    style: {
                      width: "100%",
                      padding: "14px 0",
                      borderRadius: 999,
                      background: "#8B5CF6",
                      display: "flex",
                      alignItems: "center",
                      justifyContent: "center",
                      gap: 8,
                    },
                    children: [
                      (0, s.jsx)(X.Z, { size: 16, color: "#fff" }),
                      (0, s.jsx)("span", {
                        style: { fontSize: 15, fontWeight: 700, color: "#fff" },
                        children: "Start Investing",
                      }),
                    ],
                  }),
                ],
              }),
            );
          }, [x, f]),
          v = {
            dashboard: (0, s.jsx)(ed, {
              showToast: f,
              showModal: x,
              onNavigate: p,
              darkMode: c,
              toggleDarkMode: g,
            }),
            spaces: (0, s.jsx)(ec, {
              showToast: f,
              showModal: x,
              onNavigate: p,
            }),
            invoice: (0, s.jsx)(eh, {
              showToast: f,
              showModal: x,
              onNavigate: p,
            }),
            scanReceipts: (0, s.jsx)(ef, {
              showToast: f,
              showModal: x,
              onNavigate: p,
            }),
            analytics: (0, s.jsx)(ex, { showToast: f, onNavigate: p }),
            budgets: (0, s.jsx)(ep, { showToast: f, onNavigate: p }),
            subscriptions: (0, s.jsx)(eg, { showToast: f, onNavigate: p }),
          },
          z = {
            dashboard: es.bg,
            spaces: "#E9E8E5",
            invoice: "#EDECE9",
            scanReceipts: "#EDECE9",
            analytics: es.bg,
            budgets: es.bg,
            subscriptions: es.bg,
          };
        return (0, s.jsxs)(s.Fragment, {
          children: [
            (0, s.jsx)("style", {
              children: "\n        :root { --app-bg: ".concat(
                c ? "#0E0E12" : "#F1F0ED",
                "; }\n        body { background: var(--app-bg); transition: background 0.3s ease; }\n        @keyframes fadeIn { from { opacity: 0; } to { opacity: 1; } }\n        @keyframes fadeOut { from { opacity: 1; } to { opacity: 0; } }\n        @keyframes fadeInUp { from { opacity: 0; transform: translateY(16px); } to { opacity: 1; transform: translateY(0); } }\n        @keyframes slideUp { from { opacity: 0; transform: translateY(60px) scale(0.97); } to { opacity: 1; transform: translateY(0) scale(1); } }\n        @keyframes toastIn { from { opacity: 0; transform: translateX(-50%) translateY(24px) scale(0.9); } to { opacity: 1; transform: translateX(-50%) translateY(0) scale(1); } }\n        @keyframes pulse { 0%, 100% { transform: scale(1); } 50% { transform: scale(1.05); } }\n        @keyframes popIn { from { opacity: 0; transform: scale(0.85); } to { opacity: 1; transform: scale(1); } }\n        @keyframes slideInRight { from { opacity: 0; transform: translateX(20px); } to { opacity: 1; transform: translateX(0); } }\n        @keyframes scanLine { 0% { top: 0; } 50% { top: calc(100% - 2px); } 100% { top: 0; } }\n        @keyframes spin { from { transform: rotate(0deg); } to { transform: rotate(360deg); } }\n        @keyframes receiptSlideUp { from { opacity: 0; transform: translateY(100%); } to { opacity: 1; transform: translateY(0); } }\n        @keyframes receiptSlideDown { from { opacity: 1; transform: translateY(0); } to { opacity: 0; transform: translateY(100%); } }\n        @keyframes receiptStoreBounce { from { opacity: 0; transform: scale(0.3) translateY(20px); } to { opacity: 1; transform: scale(1) translateY(0); } }\n        @keyframes receiptCheckPop { 0% { transform: scale(0); } 60% { transform: scale(1.3); } 100% { transform: scale(1); } }\n        @keyframes dashDraw { from { transform: translateX(-100%); } to { transform: translateX(0); } }\n      ",
              ),
            }),
            (0, s.jsxs)("div", {
              className: "flex flex-col",
              style: {
                position: "fixed",
                inset: 0,
                width: "100%",
                height: "100%",
                background: c ? "#0E0E12" : es.bg,
                transition: "background 0.3s ease",
              },
              children: [
                (0, s.jsx)("div", {
                  style: { flex: 1, minHeight: 0 },
                  children: (0, s.jsxs)(el, {
                    dark: c,
                    children: [
                      (0, s.jsx)("div", {
                        style: {
                          flex: 1,
                          minHeight: 0,
                          overflowY: "auto",
                          animation:
                            "fadeIn" === a
                              ? "fadeIn 0.3s ease-out"
                              : "fadeOut 0.15s ease-out",
                        },
                        children: v[e],
                      }),
                      (0, s.jsx)("div", {
                        style: {
                          background: z[e] || es.bg,
                          transition: "background 0.3s ease",
                          paddingBottom: "env(safe-area-inset-bottom, 0px)",
                          paddingTop: 2,
                        },
                        children: (0, s.jsx)(ea, {
                          active: "scanReceipts" === e ? "invoice" : e,
                          onSelect: p,
                          onPlus: u,
                        }),
                      }),
                    ],
                  }),
                }),
                i && (0, s.jsx)(en, { message: i, onDone: () => o(null) }),
                r &&
                  (0, s.jsx)(eo, {
                    title: r.title,
                    onClose: () => l(null),
                    children: r.content,
                  }),
              ],
            }),
          ],
        });
      }
      function em() {
        return (0, s.jsx)(eu, {});
      }
    },
  },
  function (e) {
    e.O(0, [878, 971, 117, 744], function () {
      return e((e.s = 76762));
    }),
      (_N_E = e.O());
  },
]);
