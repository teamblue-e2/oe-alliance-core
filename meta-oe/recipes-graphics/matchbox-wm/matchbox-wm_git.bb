DESCRIPTION = "Matchbox window manager"
HOMEPAGE = "http://matchbox-project.org"
BUGTRACKER = "http://bugzilla.openedhand.com/"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://src/wm.h;endline=21;md5=a7e844465edbcf79c282369f93caa835 \
                    file://src/main.c;endline=21;md5=3e5d9f832b527b0d72dbe8e3c4c60b95 \
                    file://src/wm.c;endline=21;md5=8dc9d24477d87ef5dfbc2e4927146aab"

SECTION = "x11/wm"
DEPENDS = "libmatchbox virtual/libx11 libxext libxrender startup-notification expat gconf libxcursor libxfixes"

SRCREV = "29544f0e61cc281fc60061443a537271e1081b78"
PV = "1.2+git${SRCPV}"

SRC_URI = "git://git.yoctoproject.org/matchbox-window-manager \
           file://kbdconfig"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES:${PN} = "${bindir}/* \
               ${datadir}/matchbox \
               ${sysconfdir}/matchbox \
               ${datadir}/themes/blondie/matchbox \
               ${datadir}/themes/Default/matchbox \
               ${datadir}/themes/MBOpus/matchbox"

EXTRA_OECONF = " --enable-startup-notification \
                 --disable-xrm \
                 --enable-expat \
                 --with-expat-lib=${STAGING_LIBDIR} \
                 --with-expat-includes=${STAGING_INCDIR}"

do_install:prepend() {
	install ${WORKDIR}/kbdconfig ${S}/data/kbdconfig
}
