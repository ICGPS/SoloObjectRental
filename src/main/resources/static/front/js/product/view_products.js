window.addEventListener("DOMContentLoaded", function() {
    const { ajaxLoad } = commonLib;

    let viewProducts = localStorage.getItem('viewProducts');
    if (!viewProducts) {
        return;
    }

    viewProducts = JSON.parse(viewProducts);

    const qs = viewProducts.map(p => `seq=${p.seq}`).join('&');
    const tpl = document.getElementById("products_tpl").innerHTML;
    const targetEl = document.querySelector(".view_products");

    const domParser = new DOMParser();
    ajaxLoad('GET', `/api/product/view_product?${qs}`, null, 'json')
        .then(res => {
            if (!res.success || !res.data) return;
            const items = res.data;

            for (const item of items) {
                let html = tpl;
                html = html.replace(/\[url\]/g, `/product/detail/${item.seq}`)
                            .replace(/\[subject\]/g, item.name);

                const dom = domParser.parseFromString(html, "text/html");
                const li = dom.querySelector("li");
                targetEl.appendChild(li);
            }
        })
        .catch(err => console.error(err));
});