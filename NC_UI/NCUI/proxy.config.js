// {
//   "/api/*": {
//     "target": "https://localhost:8080",
//     "secure": false,
//     "changeOrigin": true,
//     "logLevel": "debug",
//     "ws": true
//   }
// }

module.exports = {
  "/api/*": {
    secure: false,
    target: "https://localhost:8080",
    changeOrigin: true
    // "bypass": (req, res, proxyOptions) => {
    //   res.setHeader('Access-Control-Allow-Headers', "Content-Type");
    // }
  }
};
