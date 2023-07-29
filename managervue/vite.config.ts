import AutoImport from "unplugin-auto-import/vite";
import { ElementPlusResolver } from "unplugin-vue-components/resolvers";
import Components from "unplugin-vue-components/vite";
import { createSvgIconsPlugin } from "vite-plugin-svg-icons";
import { defineConfig } from 'vite'
import { prismjsPlugin } from "vite-plugin-prismjs";
import path from "path";
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    AutoImport({
      resolvers: [ElementPlusResolver()],
    }),
    Components({
      resolvers: [ElementPlusResolver()],
    }),
    createSvgIconsPlugin({
      // 指定需要缓存的图标文件夹
      iconDirs: [path.resolve(process.cwd(), "src/assets/icons")],
      // 指定symbolId格式
      symbolId: "icon-[dir]-[name]",
    }),
    prismjsPlugin({
      languages: ["java", "python", "go", "html", "json"],
      plugins: ["copy-to-clipboard"],
      theme: "okaidia",
      css: true,
    }),
  ],
  resolve:{
    alias:{
      "~": path.resolve(__dirname, "./"),
      "@": path.resolve(__dirname, "./src"),
    },
    extensions:[".mjs",".js", ".ts", ".jsx", ".tsx", ".json", ".vue"]
  },
  server: {
    open: true,
    proxy: {
      "/api":{
        target: "http://localhost:9080",
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/,"")
      }
    }
  }
})
