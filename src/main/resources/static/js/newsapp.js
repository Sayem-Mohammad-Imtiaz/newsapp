/**
 * Created by sayem on 11/20/2016.
 */

$(function () {
    $("#myModal").on("show.bs.modal", function (e) {
        var link = $(e.relatedTarget);
        $(this).find(".modal-title").html("Data Format: " + link.attr('data-type').toUpperCase());
        var $ref = $(this);
        $.ajax({
            url: link.attr('href'),
            type: 'get',
            success: function (data) {
                if (link.attr('data-type') == 'json') {
                    data = JSON.stringify(data, null, 4);
                    var pre = $("<pre></pre>").text(data);
                    $ref.find(".modal-body").html(pre);
                }
                else
                    $ref.find(".modal-body").html(data);
            }
        });

    });

    $('.trim-extra-spaces').bind("change paste", function () {
        if (this.value.match(/\s+/g)) {
            this.value = this.value.replace(/\s+/g, " ");
        }
        if (this.value.match(/^\s+|\s+$/g)) {
            this.value = this.value.replace(/^\s+|\s+$/g, "");
        }
    });
    $('.regular-text-regex').bind("change paste keyup", function () {
        if (this.value.match(/[?!@!#$%^&*`()~{}\=,\]\[;'"/\\+<>|:]/g)) {
            this.value = this.value.replace(/[?!@!#$%^&*`()~{}\=,\[\];'"/\\+<>|:]/g, '');
        }

    });
});