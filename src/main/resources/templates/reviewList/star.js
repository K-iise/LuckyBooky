document.addEventListener("DOMContentLoaded", () => {
    const stars = document.querySelectorAll(".stars2 .star");

    stars.forEach((star, index) => {
        star.addEventListener("mouseover", () => {
            highlightStars(index + 1);
        });

        star.addEventListener("mouseout", () => {
            resetStars();
        });
    });

    function highlightStars(count) {
        stars.forEach((star, index) => {
            if (index < count) {
                star.src = "../image/fStar.png"; // 노란색 별
            } else {
                star.src = "../image/eStar.png"; // 회색 별
            }
        });
    }

    function resetStars() {
        stars.forEach(star => {
            star.src = "../image/eStar.png"; // 기본 상태로 복원
        });
    }
});
