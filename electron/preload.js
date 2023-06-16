const { contextBridge } = require('electron')
const si = require('systeminformation');

contextBridge.exposeInMainWorld('versions', {
  node: () => process.versions.node,
  chrome: () => process.versions.chrome,
  electron: () => process.versions.electron,
  cpu: () => si.cpu()
})

si.cpu().then(data => {

  contextBridge.exposeInMainWorld('cpu', {
    manufacturer: () => data.manufacturer,
    brand: () => data.brand,
    speed: () => data.speed,
    speedMin: () => data.speedMin,
    speedMax: () => data.speedMax,
    governor: () => data.governor,
    cores: () => data.cores,
    physicalCores: () => data.physicalCores,
    performanceCores: () => data.performanceCores,
    efficiencyCores: () => data.efficiencyCores,
    processors: () => data.processors,
    socket: () => data.socket,
    vendor: () => data.vendor,
    family: () => data.family,
    model: () => data.model,
    stepping: () => data.stepping,
    revision: () => data.revision,
    voltage: () => data.voltage,
    flags: () => data.flags,
    virtualization: () => data.virtualization,
    cache:() => data.cache
  })

});