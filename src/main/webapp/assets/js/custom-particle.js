particlesJS("particles-js", {
  particles: {
    number: {
      value: 80,
      density: {
        enable: true,
        value_area: 800
      }
    },

    color: {
      value: ["#ff4757", "#1e90ff", "#2ed573", "#ffa502", "#9c88ff"]
    },

    shape: {
      type: "circle"
    },

    opacity: {
      value: 0.7,
      random: true,
      anim: {
        enable: true,
        speed: 1,
        opacity_min: 0.2,
        sync: false
      }
    },

    size: {
      value: 6,
      random: true,
      anim: {
        enable: true,
        speed: 3,
        size_min: 2,
        sync: false
      }
    },

    line_linked: {
      enable: false
    },

    move: {
      enable: true,
      speed: 1.3,
      random: true,
      out_mode: "out"
    }
  },

  interactivity: {
    detect_on: "canvas",
    events: {
      onhover: {
        enable: true,
        mode: "bubble"
      },
      onclick: {
        enable: true,
        mode: "push"
      }
    },

    modes: {
      bubble: {
        distance: 150,
        size: 10,
        duration: 2,
        opacity: 1
      }
    }
  },

  retina_detect: true
});