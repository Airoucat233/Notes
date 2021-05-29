@startuml
!include <archimate/Archimate>
Technology_Device(mMoniter, "主显示器")
Technology_Device(sMoniter, "副显示器")
Technology_Device(computer, "电脑")
Technology_Node(switch, "Switch")
Technology_Node(capture, "采集卡")
Technology_Node(transverter, "HDMI一分二")
Technology_Artifact(obs, "OBS")

switch-l->capture:"NS信号"
capture-up->transverter:"NS信号环出"
capture-l->computer:"NS信号"
computer-up->transverter:"电脑信号2\nHDMI"
transverter-up->sMoniter:"NS信号/电脑信号2"
computer-up-obs:""
obs-up->mMoniter:"电脑信号1\nDP"
@enduml