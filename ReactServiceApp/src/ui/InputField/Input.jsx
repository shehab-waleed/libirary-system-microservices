import { forwardRef, useState } from "react";
import { useMotionTemplate, useMotionValue, motion } from "framer-motion";
import { cn } from "@utils/cn";

const Input = forwardRef(
    ({ id, className, type, placeholder, ...props }, ref) => {
        const radius = 350; // change this to increase the radius of the hover effect
        const [visible, setVisible] = useState(false);

        let mouseX = useMotionValue(0);
        let mouseY = useMotionValue(0);

        function handleMouseMove({ currentTarget, clientX, clientY }) {
            const { left, top } = currentTarget.getBoundingClientRect();

            mouseX.set(clientX - left);
            mouseY.set(clientY - top);
        }

        return (
            <motion.div
                style={{
                    background: useMotionTemplate`
        radial-gradient(
          ${visible ? radius + "px" : "0px"} circle at ${mouseX}px ${mouseY}px,
          var(--brand-500),
          transparent 80%
        )
      `,
                }}
                onMouseMove={handleMouseMove}
                onMouseEnter={() => setVisible(true)}
                onMouseLeave={() => setVisible(false)}
                className="p-[3px] rounded-lg transition duration-300 group/input"
            >
                <input
                    id={id}
                    type={type}
                    placeholder={placeholder}
                    className={cn(
                        `flex h-10 w-full border-none bg-gray-50 dark:bg-zinc-800 text-black dark:text-white shadow-input rounded-md px-4 py-6 text-2xl file:border-0 file:bg-transparent file:text-sm file:font-medium placeholder:text-neutral-400 dark:placeholder-text-neutral-600 focus-visible:outline-none focus-visible:ring-[2px]  focus-visible:ring-brand-500 dark:focus-visible:ring-neutral-600 disabled:cursor-not-allowed disabled:opacity-50 dark:shadow-[0px_0px_1px_1px_var(--neutral-700)] group-hover/input:shadow-none transition duration-400`,
                        className
                    )}
                    ref={ref}
                    {...props}
                />
            </motion.div>
        );
    }
);
Input.displayName = "Input";

export { Input };
